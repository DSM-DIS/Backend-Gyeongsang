package com.dsm.gyeongsang.controller;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.Participant;
import com.dsm.gyeongsang.domains.domain.ParticipantId;
import com.dsm.gyeongsang.domains.domain.User;
import com.dsm.gyeongsang.domains.form.DiaryBookListResponseForm;
import com.dsm.gyeongsang.domains.repository.DiaryBookRepository;
import com.dsm.gyeongsang.domains.repository.ParticipantRepository;
import com.dsm.gyeongsang.domains.repository.UserRepository;
import com.dsm.gyeongsang.utils.exception.CodeMismatchException;
import com.dsm.gyeongsang.utils.exception.IdMismatchException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diary")
@Api(value = "Participant Controller")
public class ParticipantController {

    private ParticipantRepository participantRepository;
    private DiaryBookRepository diaryBookRepository;
    private UserRepository userRepository;

    @Autowired
    public ParticipantController(ParticipantRepository participantRepository, DiaryBookRepository diaryBookRepository, UserRepository userRepository) {
        this.participantRepository = participantRepository;
        this.diaryBookRepository = diaryBookRepository;
        this.userRepository = userRepository;
    }

    @ApiOperation(value = "일기장 참여", notes = "participation_personnel_list 테이블에 code, User 매칭")
    @ApiResponses({
            @ApiResponse(code = 200, message = "정상적인 응답"),
            @ApiResponse(code = 404, message = "아이디 매칭 실패 또는 코드 매칭 실패"),
            @ApiResponse(code = 500, message = "500")
    })
    @PostMapping("/diary-participation")
    public void participate(@ApiParam(value = "ididididid", required = true) @RequestParam("id") String id,
                            @ApiParam(value = "030816", required = true) @RequestParam("code") String code) {
        DiaryBook diaryBook = diaryBookRepository.findByCode(code)
                .orElseThrow(() -> new CodeMismatchException());
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IdMismatchException());
        Participant participant = new Participant(user, diaryBook);

        participantRepository.save(participant);
    }

    @ApiOperation(value = "일기장 참여", notes = "participation_personnel_list 테이블에 code, User 매칭")
    @ApiResponses({
            @ApiResponse(code = 200, message = "정상적인 응답"),
            @ApiResponse(code = 404, message = "아이디 매칭 실패 또는 코드 매칭 실패"),
            @ApiResponse(code = 500, message = "500")
    })
    @GetMapping("/diary-book")
    public DiaryBookListResponseForm viewDiaryBook(@ApiParam(value = "ididididid", required = true) @RequestParam("id") String id) {
        List<DiaryBook> diaryBookList = participantRepository.findByUser(id);

        DiaryBookListResponseForm form = new DiaryBookListResponseForm(diaryBookList);

        return form;
    }
}
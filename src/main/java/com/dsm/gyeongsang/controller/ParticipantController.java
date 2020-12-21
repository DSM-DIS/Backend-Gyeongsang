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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
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

    @GetMapping("/repositories/diary-book")
    public DiaryBookListResponseForm getDiaryBook(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        System.out.println("들어가기 전");
        List<DiaryBook> diaryBookList = participantRepository.findByUser(userId);

        diaryBookList.forEach(System.out::println);

        DiaryBookListResponseForm form = new DiaryBookListResponseForm(diaryBookList);

        return form;
    }

    @PostMapping("/repositories/diary-book")
    public void participate(HttpServletRequest request, @RequestBody String code) {
        String userId = request.getHeader("userId");

        DiaryBook diaryBook = diaryBookRepository.findByCode(code)
                .orElseThrow(CodeMismatchException::new);
        User user = userRepository.findById(userId)
                .orElseThrow(IdMismatchException::new);
        Participant participant = new Participant(user, diaryBook);

        participantRepository.save(participant);
    }
}
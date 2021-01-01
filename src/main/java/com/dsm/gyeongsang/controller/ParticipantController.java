package com.dsm.gyeongsang.controller;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.Participant;
import com.dsm.gyeongsang.domains.domain.User;
import com.dsm.gyeongsang.domains.form.CodeRequestForm;
import com.dsm.gyeongsang.domains.form.DiaryBookResponseForm;
import com.dsm.gyeongsang.domains.repository.DiaryBookRepository;
import com.dsm.gyeongsang.domains.repository.ParticipantRepository;
import com.dsm.gyeongsang.domains.repository.UserRepository;
import com.dsm.gyeongsang.utils.exception.CodeMismatchException;
import com.dsm.gyeongsang.utils.exception.IdMismatchException;
import com.google.gson.Gson;
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
    public DiaryBookResponseForm getDiaryBook(HttpServletRequest request) {
        String userId = request.getHeader("userId");
        System.out.println("getgetget :: " + userId);
        List<DiaryBook> diaryBookList = participantRepository.findByUser(userId);
        diaryBookList.forEach(System.out::println);
        System.out.println("-----------------------");
        return new DiaryBookResponseForm(diaryBookList);
    }

    @PostMapping("/repositories/diary-book")
    public void participate(@RequestBody String body) {
        System.out.println("postpostpost");
        System.out.println("code1 :" + body);
        CodeRequestForm form = new Gson().fromJson(body, CodeRequestForm.class);
        System.out.println("code2 : " + form.getCode());

        DiaryBook diaryBook = diaryBookRepository.findByCode(form.getCode())
                .orElseThrow(CodeMismatchException::new);
        User user = userRepository.findById(form.getUserId())
                .orElseThrow(IdMismatchException::new);
        Participant participant = new Participant(user, diaryBook);

        participantRepository.save(participant);
    }
}
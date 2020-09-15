package com.dsm.gyeongsang.controller;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.Participant;
import com.dsm.gyeongsang.domains.domain.ParticipantId;
import com.dsm.gyeongsang.domains.domain.User;
import com.dsm.gyeongsang.domains.repository.DiaryBookRepository;
import com.dsm.gyeongsang.domains.repository.ParticipantRepository;
import com.dsm.gyeongsang.domains.repository.UserRepository;
import com.dsm.gyeongsang.utils.exception.CodeMismatchException;
import com.dsm.gyeongsang.utils.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/diary")
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

    @PostMapping("/diary-participation")
    public void participate(@RequestParam("id") String id, @RequestParam("code") String code) {
        DiaryBook diaryBook = diaryBookRepository.findByCode(code)
                .orElseThrow(() -> new CodeMismatchException());
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IdMismatchException());
        Participant participant = new Participant(user, diaryBook);

        participantRepository.save(participant);
    }
}
package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.User;

import java.util.List;

public interface ParticipantCustomRepository {
    List<DiaryBook> findByUser(User user);
}

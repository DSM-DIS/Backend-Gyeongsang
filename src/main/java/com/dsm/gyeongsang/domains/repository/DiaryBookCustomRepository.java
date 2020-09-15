package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;

import java.util.Optional;

public interface DiaryBookCustomRepository {
    Optional<DiaryBook> findByCode(String code);
}

package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiaryBookRepository extends JpaRepository<DiaryBook, Integer>, DiaryBookCustomRepository {
}

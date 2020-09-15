package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Optional;

public class DiaryBookCustomRepositoryImpl implements DiaryBookCustomRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<DiaryBook> findByCode(String code) {
        return entityManager.createQuery("SELECT d FROM DiaryBook d WHERE d.code = :code", DiaryBook.class)
                .setParameter("code", code)
                .getResultList()
                .stream()
                .findAny();
    }
}

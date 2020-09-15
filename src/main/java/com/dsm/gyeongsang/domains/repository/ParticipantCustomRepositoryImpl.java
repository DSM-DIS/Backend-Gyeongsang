package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class ParticipantCustomRepositoryImpl implements ParticipantCustomRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<DiaryBook> findByUser(User user) {
        return entityManager.createQuery("SELECT p.diary_book_id FROM Participant p WHERE p.user_id = :user_id", DiaryBook.class)
                .setParameter("user_id", user.getId())
                .getResultList();
    }
}

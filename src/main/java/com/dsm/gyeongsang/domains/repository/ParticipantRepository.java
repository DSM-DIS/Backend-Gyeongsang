package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.DiaryBook;
import com.dsm.gyeongsang.domains.domain.Participant;
import com.dsm.gyeongsang.domains.domain.ParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, ParticipantId>, ParticipantCustomRepository {
}

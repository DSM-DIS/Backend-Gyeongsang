package com.dsm.gyeongsang.domains.repository;

import com.dsm.gyeongsang.domains.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

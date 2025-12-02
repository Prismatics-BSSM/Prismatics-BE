package org.science.prismatics.repository;

import org.science.prismatics.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdRepository extends JpaRepository<UserId, Integer> {
    UserId findByUserId(byte[] userId);
}

package org.science.prismatics.repository;

import org.science.prismatics.entity.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserIdRepository extends JpaRepository<UserId, Integer> {
    Optional<UserId> findByUserId(byte[] userId);

    @Modifying
    @Query("delete from UserId u where u.expireTime < :now")
    void deleteByExpireTimeBefore(LocalDateTime now);
}

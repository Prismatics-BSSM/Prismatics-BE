package org.science.prismatics.repository;

import org.science.prismatics.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {
    @Query("select h.id from History h where h.user.userId = :userId order by h.id")
    List<Long> getHistoryIdsByUserId(byte[] userId);
}

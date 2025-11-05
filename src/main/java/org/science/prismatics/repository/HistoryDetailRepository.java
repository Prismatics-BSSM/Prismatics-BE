package org.science.prismatics.repository;

import org.science.prismatics.entity.HistoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HistoryDetailRepository extends JpaRepository<HistoryDetail, Long> {
    @Query("select h from HistoryDetail h where h.history = :historyId")
    List<HistoryDetail> findHistoryId(@Param("historyId") Long historyId);
}

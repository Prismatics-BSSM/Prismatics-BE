package org.science.prismatics.repository;

import org.science.prismatics.entity.HistoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryDetailRepository extends JpaRepository<HistoryDetail, Long> {
    @Query("select hd.element.id from HistoryDetail hd where hd.history.id = :historyId order by hd.element.id")
    List<Integer> getElementIdsByHistoryId(long historyId);
}

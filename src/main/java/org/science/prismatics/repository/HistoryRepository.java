package org.science.prismatics.repository;

import org.science.prismatics.entity.Histories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<Histories, Long> {
}

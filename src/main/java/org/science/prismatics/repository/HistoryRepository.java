package org.science.prismatics.repository;

import jakarta.annotation.Nonnull;
import org.science.prismatics.entity.Histories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<Histories, Long> {
    List<Long> findAllByUserId(byte[] userId);

    void deleteById(long id);
}

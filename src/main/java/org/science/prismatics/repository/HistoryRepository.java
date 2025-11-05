package org.science.prismatics.repository;

import jakarta.annotation.Nonnull;
import org.science.prismatics.entity.Histories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<Histories, Long> {
    boolean existsByUserId(byte[] userId);
    List<Long> findAllByUserId(byte[] userId);

    boolean existsById(long id);
    void deleteById(long id);
}

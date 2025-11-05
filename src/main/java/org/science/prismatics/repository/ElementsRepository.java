package org.science.prismatics.repository;

import jakarta.annotation.Nonnull;
import org.science.prismatics.entity.Elements;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ElementsRepository extends JpaRepository<Elements, Integer> {
    @Nonnull
    Optional<Elements> findById(int Id);
}

package org.science.prismatics.repository;

import org.science.prismatics.entity.Waves;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaveRepository extends JpaRepository<Waves, Long> {
}

package org.science.prismatics.repository;

import org.science.prismatics.entity.Wave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaveRepository extends JpaRepository<Wave, Long> {
}

package org.science.prismatics.repository;

import org.science.prismatics.dto.WaveInfo;
import org.science.prismatics.entity.Waves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WaveRepository extends JpaRepository<Waves, Long> {
    @Query("select new org.science.prismatics.dto.WaveInfo(wavelength, alpha) from Waves where element.id = :elementId")
    List<WaveInfo> findByElementId(@Param("elementId") Integer elementId);
}

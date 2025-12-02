package org.science.prismatics.repository;

import org.science.prismatics.entity.Wave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WaveRepository extends JpaRepository<Wave, Long> {
    @Query("select distinct w.wavelength from Wave w where w.element.id in :ids")
    List<Integer> getWaveLengthsByIds(List<Integer> ids);
}

package org.science.prismatics.repository;

import org.science.prismatics.entity.Colors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorsRepository extends JpaRepository<Colors, Short> {
    Colors findByWavelength(Short wavelength);
}

package org.science.prismatics.repository;

import org.science.prismatics.entity.Element;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementRepository extends JpaRepository<Element, Integer> {
}

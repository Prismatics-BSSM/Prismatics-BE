package org.science.prismatics.repository;

import org.science.prismatics.entity.IonizationEnergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IonizationEnergyRepository extends JpaRepository<IonizationEnergy, Integer> {
    @Query("select i.amount from IonizationEnergy i where i.element.id = :elementId order by i.stage")
    List<Double> getAmountsByElementId(Integer elementId);
}

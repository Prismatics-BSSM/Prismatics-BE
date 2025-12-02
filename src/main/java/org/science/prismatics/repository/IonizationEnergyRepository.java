package org.science.prismatics.repository;

import org.science.prismatics.entity.IonizationEnergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IonizationEnergyRepository extends JpaRepository<IonizationEnergy, Integer> {
    @Query("select amount from IonizationEnergy where element.id = :elementId order by stage")
    List<Double> getAmountsByElementId(Integer elementId);
}

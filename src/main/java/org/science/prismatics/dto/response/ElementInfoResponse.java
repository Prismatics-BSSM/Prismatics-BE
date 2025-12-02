package org.science.prismatics.dto.response;

import org.science.prismatics.entity.Element;

import java.util.List;

public record ElementInfoResponse(
        Integer elementId,
        String symbol,
        String name,
        Double atomicWeight,
        Boolean hasSpectrumData,
        String energyLevels,
        Double electronegativity,
        Double meltingPoint,
        Double boilingPoint,
        Integer radius,
        String discover,
        String state,
        List<Double> ionizationEnergies
) {
    public static ElementInfoResponse from(Element element, List<Double> ionizationEnergies) {
        return new ElementInfoResponse(
                element.getId(),
                element.getSymbol(),
                element.getName(),
                element.getAtomicWeight(),
                element.isHasSpectrumData(),
                element.getEnergyLevels(),
                element.getElectronegativity(),
                element.getMeltingPoint(),
                element.getBoilingPoint(),
                element.getRadius(),
                element.getDiscover(),
                element.getState(),
                ionizationEnergies
        );
    }
}

package org.science.prismatics.dto.response;

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
        String state
) {
}

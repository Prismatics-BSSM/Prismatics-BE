package org.science.prismatics.dto.response;

public record ElementsInfoResponse(
        int id,
        String symbol,
        String name,
        Double atomicWeight,
        Boolean hasSpectrumData
) {
}

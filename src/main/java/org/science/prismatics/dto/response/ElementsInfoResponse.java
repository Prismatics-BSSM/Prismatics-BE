package org.science.prismatics.dto.response;

import org.science.prismatics.entity.Elements;

public record ElementsInfoResponse(
        int id,
        String symbol,
        String name,
        Double atomicWeight,
        Boolean hasSpectrumData
) {
    public static ElementsInfoResponse from(Elements elements) {
        return new ElementsInfoResponse(
                elements.getId(),
                elements.getSymbol(),
                elements.getName(),
                elements.getAtomicWeight(),
                elements.getHasSpectrumData()
        );
    }
}

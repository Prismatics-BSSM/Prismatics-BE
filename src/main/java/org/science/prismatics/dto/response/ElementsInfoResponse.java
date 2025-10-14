package org.science.prismatics.dto.response;

import java.math.BigDecimal;

public record ElementsInfoResponse(
        int id,
        String symbol,
        String name,
        BigDecimal weight
) {
}

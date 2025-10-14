package org.science.prismatics.dto.response;

import java.util.List;

public record SpectrumInfoResponse(
        int id,
        List<Integer> waves
) {
}

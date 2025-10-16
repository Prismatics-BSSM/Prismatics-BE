package org.science.prismatics.dto.response;

import org.science.prismatics.dto.WaveInfo;

import java.util.List;

public record SpectrumInfoResponse(
        List<WaveInfo> waves
) {
}

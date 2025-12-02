package org.science.prismatics.dto.request;

import java.util.List;

public record CreateHistoryRequest(
        List<Integer> elementIds
) {
}

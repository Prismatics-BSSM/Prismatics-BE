package org.science.prismatics.dto.response;

import java.util.List;

public record HistoryRecordResponse(
        Long historyId,
        List<Integer> elementIds
) {
}

package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.HistoryRecordResponse;
import org.science.prismatics.error.exception.BadRequestException;
import org.science.prismatics.error.exception.UserIdExpiredException;
import org.science.prismatics.repository.HistoryDetailRepository;
import org.science.prismatics.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;
    private final AuthService authService;

    public List<HistoryRecordResponse> getHistoriesByUserId(byte[] userId) {
        if (userId == null) throw new BadRequestException();
        if (authService.isExpired(userId)) throw new UserIdExpiredException();

        List<HistoryRecordResponse> response = new ArrayList<>();

        List<Long> historyIds = historyRepository.getHistoryIdsByUserId(userId);
        for (Long historyId : historyIds) {
            List<Integer> elementIds = historyDetailRepository.getElementIdsByHistoryId(historyId);
            response.add(new HistoryRecordResponse(historyId, elementIds));
        }
        return response;
    }
}

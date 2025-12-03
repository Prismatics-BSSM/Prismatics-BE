package org.science.prismatics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.request.CreateHistoryRequest;
import org.science.prismatics.dto.response.HistoryRecordResponse;
import org.science.prismatics.entity.Element;
import org.science.prismatics.entity.History;
import org.science.prismatics.entity.HistoryDetail;
import org.science.prismatics.entity.UserId;
import org.science.prismatics.error.exception.HistoryNotFoundException;
import org.science.prismatics.error.exception.UserIdInValidException;
import org.science.prismatics.error.exception.UserIncorrectException;
import org.science.prismatics.repository.HistoryDetailRepository;
import org.science.prismatics.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;
    private final AuthService authService;

    public List<HistoryRecordResponse> getHistoriesByUserId(UUID uuid) {
        byte[] userId = authService.uuidToBytes(uuid);
        if (authService.getValidUser(userId) == null) throw new UserIdInValidException();

        List<HistoryRecordResponse> response = new ArrayList<>();

        List<Long> historyIds = historyRepository.getHistoryIdsByUserId(userId);
        for (Long historyId : historyIds) {
            List<Integer> elementIds = historyDetailRepository.getElementIdsByHistoryId(historyId);
            response.add(new HistoryRecordResponse(historyId, elementIds));
        }
        return response;
    }

    @Transactional
    public HistoryRecordResponse createNewHistory(UUID uuid, CreateHistoryRequest request) {

        byte[] userIdBytes = authService.uuidToBytes(uuid);
        UserId user = authService.getValidUser(userIdBytes);

        if (user == null) {
            throw new UserIdInValidException();
        }

        History history = new History();
        history.setUser(user);
        history = historyRepository.save(history);

        List<HistoryDetail> details = new ArrayList<>();
        for (Integer elementId : request.elementIds()) {
            HistoryDetail detail = new HistoryDetail();
            detail.setHistory(history);

            Element elementRef = new Element();
            elementRef.setId(elementId);

            detail.setElement(elementRef);
            details.add(detail);
        }

        historyDetailRepository.saveAll(details);

        return new HistoryRecordResponse(history.getId(), request.elementIds());
    }

    @Transactional
    public void deleteHistory(UUID uuid, Long historyId) {
        byte[] userIdBytes = authService.uuidToBytes(uuid);

        UserId user = authService.getValidUser(userIdBytes);
        if (user == null) throw new UserIdInValidException();

        History history = historyRepository.findById(historyId)
                .orElseThrow(HistoryNotFoundException::new);

        if (!Arrays.equals(history.getUser().getUserId(), userIdBytes)) {
            throw new UserIncorrectException();
        }

        historyRepository.delete(history);
    }
}

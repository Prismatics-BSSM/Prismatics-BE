package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.entity.HistoryDetail;
import org.science.prismatics.repository.HistoryDetailRepository;
import org.science.prismatics.repository.HistoryRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;

    public List<HistoryDetail> findByHistoryId(Long historyId) throws Exception {
        List<HistoryDetail> historyDetails = historyDetailRepository.findByHistoryId(historyId);
        if (historyDetails.isEmpty()) {
            throw new Exception("History not found");
        }
        return historyDetails;
    }

    public void removeHistoryByHistoryId(long id) throws Exception {
        if (!historyRepository.existsById(id)) {
            throw new Exception("History not found");
        }
        historyRepository.deleteById(id);
    }
}

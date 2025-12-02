package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.repository.HistoryDetailRepository;
import org.science.prismatics.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryDetailRepository historyDetailRepository;
}

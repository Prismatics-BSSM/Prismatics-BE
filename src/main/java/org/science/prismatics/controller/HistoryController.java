package org.science.prismatics.controller;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.request.CreateHistoryRequest;
import org.science.prismatics.dto.response.HistoryRecordResponse;
import org.science.prismatics.service.HistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/histories")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<HistoryRecordResponse>> getHistoriesByUserId(@RequestParam("userid") UUID userId) {
        List<HistoryRecordResponse> list = historyService.getHistoriesByUserId(userId);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<HistoryRecordResponse> createHistory(
            @RequestParam("userid") UUID userId, @RequestBody CreateHistoryRequest request) {
        HistoryRecordResponse response = historyService.createNewHistory(userId, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistory(
            @RequestParam("userid") UUID userId, @PathVariable("id") Long historyId) {
        historyService.deleteHistory(userId, historyId);
        return ResponseEntity.ok().build();
    }
}

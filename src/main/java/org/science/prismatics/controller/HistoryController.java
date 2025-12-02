package org.science.prismatics.controller;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.service.HistoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/histories")
public class HistoryController {
    private final HistoryService historyService;
}

package org.science.prismatics.controller;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.ElementInfoResponse;
import org.science.prismatics.dto.response.SpectrumInfoResponse;
import org.science.prismatics.service.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/elements")
public class ElementController {
    private final ElementService elementService;

    @GetMapping("/{id}")
    public ResponseEntity<ElementInfoResponse> getElementInfoById(@PathVariable Integer id) {
        ElementInfoResponse elementInfo = elementService.getElementInfoById(id);
        return ResponseEntity.ok(elementInfo);
    }

    @GetMapping("/spectrums")
    public ResponseEntity<SpectrumInfoResponse> getSpectrumInfoByIds(@RequestParam List<Integer> ids) {
        SpectrumInfoResponse spectrum = elementService.getSpectrumByElementIds(ids);
        return ResponseEntity.ok(spectrum);
    }
}

package org.science.prismatics.controller;

import ch.qos.logback.core.joran.spi.HttpUtil;
import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.ElementsInfoResponse;
import org.science.prismatics.dto.response.SpectrumInfoResponse;
import org.science.prismatics.service.ElementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/element")
public class ElementController {
    private final ElementService elementService;

    @GetMapping("/{id}")
    public ResponseEntity<ElementsInfoResponse> getElementById(@PathVariable("id") Integer id) {
        try {
            ElementsInfoResponse elementsInfoResponse =
                    ElementsInfoResponse.from(elementService.findElementInfoById(id));
            return ResponseEntity.ok(elementsInfoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/spectrum/{id}")
    public ResponseEntity<SpectrumInfoResponse> getSpectrumById(@PathVariable("id") Integer id) {
        try {
            SpectrumInfoResponse spectrumInfoResponse =
                    new SpectrumInfoResponse(elementService.findWaveInfoByElementId(id));
            return ResponseEntity.ok(spectrumInfoResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}

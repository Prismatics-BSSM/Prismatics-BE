package org.science.prismatics.controller;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.ColorResponse;
import org.science.prismatics.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping("/color/{wavelength}")
    public ResponseEntity<ColorResponse> getColor(@PathVariable("wavelength") short wavelength) {
        try {
            ColorResponse colorResponse =
                    ColorResponse.from(colorService.findColorByWavelength(wavelength));
            return ResponseEntity.ok(colorResponse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}

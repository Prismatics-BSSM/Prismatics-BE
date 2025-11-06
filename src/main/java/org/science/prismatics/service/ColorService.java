package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.entity.Colors;
import org.science.prismatics.repository.ColorsRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorsRepository colorsRepository;

    public Colors findColorByWavelength(Short wavelength) throws Exception {
        Colors colors = colorsRepository.findByWavelength(wavelength);
        if (colors == null) {
            throw new Exception("Color not found");
        }
        return colors;
    }
}

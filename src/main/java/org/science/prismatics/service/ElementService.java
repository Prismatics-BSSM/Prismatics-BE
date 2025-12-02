package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.ElementInfoResponse;
import org.science.prismatics.dto.response.SpectrumInfoResponse;
import org.science.prismatics.entity.Element;
import org.science.prismatics.error.exception.BadRequestException;
import org.science.prismatics.error.exception.ElementNotFoundException;
import org.science.prismatics.repository.ElementRepository;
import org.science.prismatics.repository.IonizationEnergyRepository;
import org.science.prismatics.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;
    private final WaveRepository waveRepository;
    private final IonizationEnergyRepository ionizationEnergyRepository;

    public ElementInfoResponse getElementInfoById(Integer id) {
        Element element = elementRepository.findById(id).orElse(null);
        if (element == null) throw new ElementNotFoundException();

        List<Double> ionizationEnergies = ionizationEnergyRepository.getAmountsByElementId(id);

        return ElementInfoResponse.from(element, ionizationEnergies);
    }

    public SpectrumInfoResponse getSpectrumByElementIds(List<Integer> ids) {
        if (ids.isEmpty()) throw new BadRequestException();
        List<Integer> waves = waveRepository.getWaveLengthsByIds(ids);
        waves.sort(Comparator.naturalOrder());
        return new SpectrumInfoResponse(waves);
    }
}

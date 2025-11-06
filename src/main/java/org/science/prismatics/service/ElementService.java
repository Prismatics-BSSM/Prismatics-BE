package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.WaveInfo;
import org.science.prismatics.entity.Elements;
import org.science.prismatics.repository.ElementsRepository;
import org.science.prismatics.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementsRepository elementsRepository;
    private final WaveRepository waveRepository;

    public Elements findElementInfoById(Integer id) throws Exception {
        Optional<Elements> element = elementsRepository.findById(id);
        if (element.isPresent()) {
            return element.get();
        }
        throw new Exception("Element not found");
    }

    public List<WaveInfo> findWaveInfoByElementId(Integer id) throws Exception {
        List<WaveInfo> waveInfos = waveRepository.findByElementId(id);
        if (waveInfos.isEmpty()) {
            throw new Exception("Element not found");
        }
        return waveInfos;
    }
}

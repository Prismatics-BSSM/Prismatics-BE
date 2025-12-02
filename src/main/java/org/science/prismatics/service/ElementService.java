package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.entity.Element;
import org.science.prismatics.repository.ElementRepository;
import org.science.prismatics.repository.IonizationEnergyRepository;
import org.science.prismatics.repository.WaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElementService {
    private final ElementRepository elementRepository;
    private final WaveRepository waveRepository;
    private final IonizationEnergyRepository ionizationEnergyRepository;
}

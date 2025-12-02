package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.repository.UserIdRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserIdRepository userIdRepository;
}

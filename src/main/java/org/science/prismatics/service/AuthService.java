package org.science.prismatics.service;

import lombok.RequiredArgsConstructor;
import org.science.prismatics.entity.UserId;
import org.science.prismatics.repository.UserIdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserIdRepository userIdRepository;

    public boolean isExpired(byte[] userId) {
        UserId userIdInfo = userIdRepository.findByUserId(userId);
        if (userIdInfo.getExpireTime().isBefore(LocalDateTime.now())) {
            userIdRepository.delete(userIdInfo);
            return true;
        }
        return false;
    }
}

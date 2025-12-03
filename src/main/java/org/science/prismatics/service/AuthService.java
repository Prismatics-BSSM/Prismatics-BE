package org.science.prismatics.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.science.prismatics.dto.response.UserIdResponse;
import org.science.prismatics.entity.UserId;
import org.science.prismatics.repository.UserIdRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserIdRepository userIdRepository;

    public UserId getValidUser(byte[] userId) {
        return userIdRepository.findByUserId(userId)
                .filter(uid -> !uid.getExpireTime().isBefore(LocalDateTime.now()))
                .orElse(null);
    }

    public byte[] uuidToBytes(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());
        return buffer.array();
    }

    @Transactional
    public UserIdResponse generateNewUserId() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer buf = ByteBuffer.allocate(16);
        buf.putLong(uuid.getMostSignificantBits());
        buf.putLong(uuid.getLeastSignificantBits());
        byte[] bytes = buf.array();

        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(300);

        UserId newUserId = new UserId();
        newUserId.setUserId(bytes);
        newUserId.setExpireTime(expireTime);

        newUserId = userIdRepository.save(newUserId);
        return UserIdResponse.from(newUserId);
    }

    @Transactional
    @Scheduled(fixedRate = 1800000) // 30분마다 실행
    public void deleteExpiredUserIds() {
        userIdRepository.deleteByExpireTimeBefore(LocalDateTime.now());
    }
}

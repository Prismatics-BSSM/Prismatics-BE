package org.science.prismatics.dto.response;

import org.science.prismatics.entity.UserId;

import java.nio.ByteBuffer;
import java.util.UUID;

public record UserIdResponse(
        String userId
) {
    public static UserIdResponse from(UserId entity) {
        byte[] bytes = entity.getUserId();

        ByteBuffer buf = ByteBuffer.wrap(bytes);
        long msb = buf.getLong();
        long lsb = buf.getLong();
        UUID uuid = new UUID(msb, lsb);

        return new UserIdResponse(uuid.toString());
    }
}

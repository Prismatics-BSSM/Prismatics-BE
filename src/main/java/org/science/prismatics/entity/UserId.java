package org.science.prismatics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_ids")
public class UserId {

    @Id
    @Column(name = "user_id", columnDefinition = "binary(16)")
    private byte[] userId;

    @Column(name = "expire_time", nullable = false)
    private LocalDateTime expireTime;
}
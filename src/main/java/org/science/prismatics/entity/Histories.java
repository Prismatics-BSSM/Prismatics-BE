package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "histories")
public class Histories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // UUID → binary(16)
    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    private byte[] userId;

    @Column(nullable = false)
    private LocalDateTime time;

    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoryDetail> historyDetails;
}
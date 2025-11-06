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
    @Column(name = "user_id", nullable = false)
    private byte[] userId;

    @Column(nullable = false, columnDefinition = "datetime(6) default current_timestamp(6)")
    private LocalDateTime time;

    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoryDetail> historyDetails;
}
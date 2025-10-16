package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "elements")
public class Elements {

    @Id
    private Integer id;

    @Column(length = 2, nullable = false, unique = true)
    private String symbol;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(name = "atomic_weight", nullable = false)
    private Double atomicWeight;

    @Column(name = "has_spectrum_data", nullable = false)
    private Boolean hasSpectrumData;

    // 관계 매핑
    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Waves> waves;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoryDetail> historyDetails;
}
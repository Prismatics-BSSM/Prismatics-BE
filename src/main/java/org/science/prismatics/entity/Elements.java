package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table
public class Elements {

    @Id
    private Integer id;

    @Column(length = 2, nullable = false, unique = true)
    private String symbol;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(precision = 10, scale = 5)
    private BigDecimal weight;

    // 관계 매핑
    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wave> waves;

    @OneToMany(mappedBy = "element", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HistoryDetail> historyDetails;

}
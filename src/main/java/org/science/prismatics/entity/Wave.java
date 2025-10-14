package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table
public class Wave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "element_id", nullable = false)
    private Elements element;

    @Column(precision = 10, scale = 5)
    private BigDecimal wavelength;
}
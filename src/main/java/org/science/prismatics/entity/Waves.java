package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(
        name = "waves",
        uniqueConstraints = @UniqueConstraint(columnNames = {"element_id", "wavelength"})
)
public class Waves {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "element_id", nullable = false)
    private Elements element;

    @Column(nullable = false)
    private Integer wavelength;

    @Column(nullable = false)
    private Double alpha;
}
package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "elements")
public class Element {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "symbol", nullable = false, length = 2, unique = true)
    private String symbol;

    @Column(name = "name", nullable = false, length = 30, unique = true)
    private String name;

    @Column(name = "atomic_weight", nullable = false)
    private double atomicWeight;

    @Column(name = "has_spectrum_data", nullable = false)
    private boolean hasSpectrumData;

    @Column(name = "energy_levels", nullable = false, length = 30)
    private String energyLevels;

    @Column(name = "electronegativity")
    private Double electronegativity;

    @Column(name = "melting_point")
    private Double meltingPoint;

    @Column(name = "boiling_point")
    private Double boilingPoint;

    @Column(name = "radius")
    private Integer radius;

    @Column(name = "discover", nullable = false, length = 10)
    private String discover;

    @Column(name = "state", nullable = false, length = 2)
    private String state;
}
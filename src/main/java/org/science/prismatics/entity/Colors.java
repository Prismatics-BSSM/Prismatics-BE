package org.science.prismatics.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="colors")
public class Colors {
    @Id
    private Short wavelength;

    @Column(nullable = false)
    private Short red;

    @Column(nullable = false)
    private Short green;

    @Column(nullable = false)
    private Short blue;
}

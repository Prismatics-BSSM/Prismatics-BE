package org.science.prismatics.entity;

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

    private Short red;
    private Short green;
    private Short blue;
}

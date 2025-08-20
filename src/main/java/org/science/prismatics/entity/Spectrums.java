package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Spectrums {
    @Id
    private Integer spectrumId;

    private Long elementId;
}

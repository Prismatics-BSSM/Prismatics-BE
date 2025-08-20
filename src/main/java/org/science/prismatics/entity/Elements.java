package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Elements {
    @Id
    private Integer elementId;

    private String symbol;
    private String name;
    private Float weight;
}

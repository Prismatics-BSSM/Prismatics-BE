package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Wave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long waveId;

    
}

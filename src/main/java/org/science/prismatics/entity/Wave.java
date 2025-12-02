package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "waves",
        uniqueConstraints = @UniqueConstraint(columnNames = {"element_id", "wavelength"}))
public class Wave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "element_id", nullable = false)
    private Element element;

    @Column(name = "wavelength", nullable = false)
    private int wavelength;
}
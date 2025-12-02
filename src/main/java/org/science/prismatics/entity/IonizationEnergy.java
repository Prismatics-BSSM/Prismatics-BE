package org.science.prismatics.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "ionization_energies")
@IdClass(IonizationEnergy.PK.class)
public class IonizationEnergy {

    @Id
    @Column(name = "stage")
    private byte stage;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "element_id", nullable = false)
    private Element element;

    @Column(name = "element_id", insertable = false, updatable = false)
    private Integer elementId;

    @Column(name = "amount")
    private Double amount;

    public static class PK implements Serializable {
        private byte stage;
        private int element;

        public PK() {}
    }
}
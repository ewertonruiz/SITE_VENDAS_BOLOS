package br.com.ewertoncorporation.boloscaseiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.*;

@Getter
@Setter
@Entity

public class ReceitaIgrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long receita_igrediente_id;

    @Column(nullable = false)
    private Double receita_igrediente_quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receita_igrediente_receita_fk")
    private Receita receita;

    @ManyToOne(optional = false)
    @JoinColumn(name = "receita_igrediente_igrediente_fk")
    private Igrediente igrediente;

    
    
}
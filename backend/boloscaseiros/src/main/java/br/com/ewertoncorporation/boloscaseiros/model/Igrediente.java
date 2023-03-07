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

public class Igrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long igrediente_id;

    @Column(nullable = false, updatable = false)
    private String igrediente_nome;

    @Column(nullable = false, updatable = false)
    private String igrediente_descricao;

    @Column(nullable = false, updatable = false)
    private Double igrediente_preco;

    @ManyToOne(optional = false)
    @JoinColumn(name = "igrediente_unidade_medida_fk")
    private Unidade_Mediada unidade_medida;
    
}
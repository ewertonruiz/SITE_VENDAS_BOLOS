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

public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long receita_id;

    @Column(nullable = false)
    private String receita_modo_preparo_nome;

    @Column(nullable = false)
    private Double receita_custo;

    @Column(nullable = false)
    private String receita_tipo;
    
}
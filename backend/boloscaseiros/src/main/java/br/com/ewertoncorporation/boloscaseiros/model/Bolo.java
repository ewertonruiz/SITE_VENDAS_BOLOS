package br.com.ewertoncorporation.boloscaseiros.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Getter
@Setter
@Entity

public class Bolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long bolo_id;

    @Column(nullable = false, updatable = false)
    private String bolo_tamanho;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bolo_sabor_receita_fk")
    private Receita receita_sabor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bolo_sabor_recheio_receita_fk")
    private Receita receita_recheio;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bolo_cobertura_receita_fk")
    private Receita receita_cobertura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "bolo_produto_fk")
    private Produto produto;

    
    
}
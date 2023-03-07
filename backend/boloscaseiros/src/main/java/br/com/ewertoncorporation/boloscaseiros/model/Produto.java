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

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long produto_id;

    @Column(nullable = false, updatable = false)
    private String produto_nome;

    @Column(nullable = false, updatable = false)
    private String produto_descricao;

    @Column(nullable = false, updatable = false)
    private Double produto_custo;

    @Column(nullable = false, updatable = false)
    private Double produto_preco;

    @Column(nullable = false, updatable = false)
    private Double produto_lucro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_tipo_produto_fk")
    private Tipo_Produto tipo_produto;
    
}
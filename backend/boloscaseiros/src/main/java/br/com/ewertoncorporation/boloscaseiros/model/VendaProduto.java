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

public class VendaProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer venda_produto_quantidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_produto_venda_fk")
    private Venda venda;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_produto_produto_fk")
    private Produto produto;
    
}
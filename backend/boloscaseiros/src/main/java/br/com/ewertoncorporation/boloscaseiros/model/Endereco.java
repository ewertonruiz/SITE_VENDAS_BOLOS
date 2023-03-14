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

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long endereco_id;

    @Column(nullable = false, updatable = false)
    private String endereco_logradouro;

    @Column(nullable = false, updatable = false)
    private String endereco_bairro;

    @Column(nullable = false, updatable = false)
    private Integer endereco_numero;

    @Column(nullable = false, updatable = false)
    private String endereco_complemento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "endereco_user_fk")
    private Usuario usuario;
    
}
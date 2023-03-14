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

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long cliente_id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_user_fk")
    private Usuario usuario;
    
}
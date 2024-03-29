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

public class TipoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long tipo_usuario_id;

    @Column(nullable = false)
    private String tipo_usuario_nome;
    
}
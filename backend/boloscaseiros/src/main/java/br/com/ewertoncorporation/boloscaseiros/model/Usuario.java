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

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long user_id;

    @Column(nullable = false, updatable = false)
    private String user_nome;

    @Column(nullable = false, updatable = false)
    private String user_login;

    @Column(nullable = false, updatable = false)
    private String user_senha;

    @Column(nullable = false, updatable = false)
    private String user_celular;

    @Column(nullable = false, updatable = false)
    private String user_email;

    @Column(nullable = false, updatable = false)
    private String user_whatsapp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_tipo_user_fk")
    private Tipo_User tipo_user;
    
}
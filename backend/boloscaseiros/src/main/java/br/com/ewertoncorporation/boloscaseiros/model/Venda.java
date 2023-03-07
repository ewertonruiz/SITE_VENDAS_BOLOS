package br.com.ewertoncorporation.boloscaseiros.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.*;

@Getter
@Setter
@Entity

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long venda_id;

    @Column(nullable = false, updatable = false)
    private Double venda_valor_total;

    @Column(nullable = false, updatable = false)
    private Double venda_lucro;

    @Column(nullable = false, updatable = false)
    private LocalDate venda_data;    

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_vendedor_fk")
    private Vendedor vendedor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "venda_cliente_fk")
    private Cliente cliente;
    
}
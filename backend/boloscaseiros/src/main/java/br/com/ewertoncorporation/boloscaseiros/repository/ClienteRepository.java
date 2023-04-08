package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.ewertoncorporation.boloscaseiros.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT cl FROM Cliente cl WHERE cl.cliente_id = ?1")
        Cliente findByAll(String id);

}

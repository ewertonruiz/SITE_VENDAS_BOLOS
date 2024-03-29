package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Venda;


public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query("SELECT ve FROM Venda ve WHERE ve.venda_id = ?1")
        Venda findByAll(String id);

}

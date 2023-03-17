package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Receita;


public interface ReceitaRepository extends JpaRepository<Receita, String> {

    @Query("SELECT pr FROM Produto pr WHERE pr.produto_nome LIKE %?1%")
    List<Receita> findByAll(String receita_modo_preparo_nome);

}

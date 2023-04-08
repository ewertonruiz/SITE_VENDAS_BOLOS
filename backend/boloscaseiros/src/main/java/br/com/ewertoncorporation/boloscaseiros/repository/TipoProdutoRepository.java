package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.TipoProduto;


public interface TipoProdutoRepository extends JpaRepository<TipoProduto, Long> {

    @Query("SELECT tp FROM TipoProduto tp WHERE tp.tipo_produto_nome LIKE %?1%")
    List<TipoProduto> findByAll(String nome);

}

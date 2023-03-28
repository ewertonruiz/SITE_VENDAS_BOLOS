package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// import br.com.ewertoncorporation.boloscaseiros.model.Venda;
import br.com.ewertoncorporation.boloscaseiros.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT pr FROM Produto pr WHERE pr.produto_nome LIKE %?1%")
    List<Produto> findByAll(String nome);

}

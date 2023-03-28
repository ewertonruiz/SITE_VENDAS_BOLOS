package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// import br.com.ewertoncorporation.boloscaseiros.model.Venda;
import br.com.ewertoncorporation.boloscaseiros.model.Vendedor;


public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT vd FROM Vendedor vd WHERE vd.vendedor_id = %?1%")
    List<Vendedor> findByAll(String id);

}

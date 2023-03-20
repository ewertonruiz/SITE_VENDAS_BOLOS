package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Vendedor;


public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT vd FROM Vendedor vd WHERE vd.id MESMO %?1%")
    List<Vendedor> findByAll(Long id);

}

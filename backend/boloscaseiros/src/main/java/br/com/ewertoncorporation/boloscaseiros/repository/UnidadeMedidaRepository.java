package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.UnidadeMedida;


public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long> {

    @Query("SELECT um FROM UnidadeMedida um WHERE um.unidade_medida_nome LIKE %?1%")
    List<UnidadeMedida> findByAll(String nome);

}

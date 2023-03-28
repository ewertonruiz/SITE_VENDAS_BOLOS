package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import br.com.ewertoncorporation.boloscaseiros.model.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT en FROM Endereco en WHERE en.endereco_id MESMO %?1%")
    List<Endereco> findByAll(String id);

}

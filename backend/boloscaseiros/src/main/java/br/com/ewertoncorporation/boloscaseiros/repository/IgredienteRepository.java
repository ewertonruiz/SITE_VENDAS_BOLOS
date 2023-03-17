package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Igrediente;


public interface IgredienteRepository extends JpaRepository<Igrediente, String> {

    @Query("SELECT ig FROM Igrediente ig WHERE ig.igrediente_nome LIKE %?1%")
    List<Igrediente> findByAll(String nome);

}

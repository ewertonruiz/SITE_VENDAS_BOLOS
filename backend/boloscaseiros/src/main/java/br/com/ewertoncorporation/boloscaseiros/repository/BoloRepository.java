package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Bolo;


public interface BoloRepository extends JpaRepository<Bolo, Long> {

    @Query("SELECT bi FROM Bolo bi WHERE bi.bolo_id = %?1%")
    List<Bolo> findByAll(String id);

}

package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.TipoUsuario;


public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

    @Query("SELECT tu FROM TipoUsuario tu WHERE tu.tipo_usuario_nome LIKE %?1%")
    List<TipoUsuario> findByAll(String nome);

}

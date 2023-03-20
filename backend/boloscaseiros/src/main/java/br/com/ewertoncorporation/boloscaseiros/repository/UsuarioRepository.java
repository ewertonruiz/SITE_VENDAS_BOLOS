package br.com.ewertoncorporation.boloscaseiros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ewertoncorporation.boloscaseiros.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT us FROM Usuario us WHERE us.user_nome LIKE %?1%")
    List<Usuario> findByAll(String nome);

}

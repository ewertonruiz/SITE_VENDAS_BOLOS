// package br.com.ewertoncorporation.boloscaseiros.repository;

// import java.util.List;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;

// import br.com.ewertoncorporation.boloscaseiros.model.ReceitaIgrediente;


// public interface ReceitaIgredienteRepository extends JpaRepository<ReceitaIgrediente, Long> {

//     @Query("SELECT ri FROM TipoUsuario ri WHERE ri.receita_igrediente_id MESMO %?1%")
//     List<ReceitaIgrediente> findByAll(Long id);

// }

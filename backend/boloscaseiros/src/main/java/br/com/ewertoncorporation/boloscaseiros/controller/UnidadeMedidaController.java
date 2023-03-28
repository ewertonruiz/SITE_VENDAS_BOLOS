package br.com.ewertoncorporation.boloscaseiros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ewertoncorporation.boloscaseiros.model.UnidadeMedida;
import br.com.ewertoncorporation.boloscaseiros.service.UnidadeMedidaService;

@RestController
@RequestMapping("/unidademedida")
public class UnidadeMedidaController implements ICrudController<UnidadeMedida>{
    UnidadeMedidaService service;
   @Autowired
    public UnidadeMedidaController(UnidadeMedidaService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<UnidadeMedida>> getAll() {
        List<UnidadeMedida> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeMedida> getById(@PathVariable("id") Long id) {
        UnidadeMedida registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<UnidadeMedida>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<UnidadeMedida> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<UnidadeMedida> insert(@RequestBody UnidadeMedida objeto) {
        UnidadeMedida registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<UnidadeMedida> update(@RequestBody UnidadeMedida objeto) {
        UnidadeMedida registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

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

import br.com.ewertoncorporation.boloscaseiros.model.Receita;
import br.com.ewertoncorporation.boloscaseiros.service.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController implements ICrudController<Receita>{
    ReceitaService service;
   @Autowired
    public ReceitaController(ReceitaService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Receita>> getAll() {
        List<Receita> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Receita> getById(@PathVariable("id") Long id) {
        Receita registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Receita>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Receita> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Receita> insert(@RequestBody Receita objeto) {
        Receita registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Receita> update(@RequestBody Receita objeto) {
        Receita registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

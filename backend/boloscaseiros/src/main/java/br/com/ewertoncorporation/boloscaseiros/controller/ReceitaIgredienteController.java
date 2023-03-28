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

import br.com.ewertoncorporation.boloscaseiros.model.ReceitaIgrediente;
import br.com.ewertoncorporation.boloscaseiros.service.ReceitaIgredienteService;

@RestController
@RequestMapping("/receitaigrediente")
public class ReceitaIgredienteController implements ICrudController<ReceitaIgrediente>{
    ReceitaIgredienteService service;
   @Autowired
    public ReceitaIgredienteController(ReceitaIgredienteService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<ReceitaIgrediente>> getAll() {
        List<ReceitaIgrediente> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ReceitaIgrediente> getById(@PathVariable("id") Long id) {
        ReceitaIgrediente registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<ReceitaIgrediente>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<ReceitaIgrediente> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<ReceitaIgrediente> insert(@RequestBody ReceitaIgrediente objeto) {
        ReceitaIgrediente registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<ReceitaIgrediente> update(@RequestBody ReceitaIgrediente objeto) {
        ReceitaIgrediente registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

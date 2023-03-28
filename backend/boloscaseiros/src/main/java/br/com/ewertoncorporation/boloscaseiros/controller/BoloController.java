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

import br.com.ewertoncorporation.boloscaseiros.model.Bolo;
import br.com.ewertoncorporation.boloscaseiros.service.BoloService;

@RestController
@RequestMapping("/bolo")
public class BoloController implements ICrudController<Bolo>{
    BoloService service;
   @Autowired
    public BoloController(BoloService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Bolo>> getAll() {
        List<Bolo> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Bolo> getById(@PathVariable("id") Long id) {
        Bolo registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Bolo>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Bolo> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Bolo> insert(@RequestBody Bolo objeto) {
        Bolo registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Bolo> update(@RequestBody Bolo objeto) {
        Bolo registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

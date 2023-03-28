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

import br.com.ewertoncorporation.boloscaseiros.model.Cliente;
import br.com.ewertoncorporation.boloscaseiros.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements ICrudController<Cliente>{
    ClienteService service;
   @Autowired
    public ClienteController(ClienteService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable("id") Long id) {
        Cliente registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Cliente>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Cliente> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Cliente> insert(@RequestBody Cliente objeto) {
        Cliente registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Cliente> update(@RequestBody Cliente objeto) {
        Cliente registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

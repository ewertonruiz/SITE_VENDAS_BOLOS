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

import br.com.ewertoncorporation.boloscaseiros.model.Vendedor;
import br.com.ewertoncorporation.boloscaseiros.service.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController implements ICrudController<Vendedor>{
    VendedorService service;
   @Autowired
    public VendedorController(VendedorService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Vendedor>> getAll() {
        List<Vendedor> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getById(@PathVariable("id") Long id) {
        Vendedor registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<Vendedor>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<Vendedor> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Vendedor> insert(@RequestBody Vendedor objeto) {
        Vendedor registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Vendedor> update(@RequestBody Vendedor objeto) {
        Vendedor registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

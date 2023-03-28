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

import br.com.ewertoncorporation.boloscaseiros.model.VendaProduto;
import br.com.ewertoncorporation.boloscaseiros.service.VendaProdutoService;

@RestController
@RequestMapping("/vendaproduto")
public class VendaProdutoController implements ICrudController<VendaProduto>{
    VendaProdutoService service;
   @Autowired
    public VendaProdutoController(VendaProdutoService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<VendaProduto>> getAll() {
        List<VendaProduto> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<VendaProduto> getById(@PathVariable("id") Long id) {
        VendaProduto registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<VendaProduto>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<VendaProduto> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<VendaProduto> insert(@RequestBody VendaProduto objeto) {
        VendaProduto registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<VendaProduto> update(@RequestBody VendaProduto objeto) {
        VendaProduto registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

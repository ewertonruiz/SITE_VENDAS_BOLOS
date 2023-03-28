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

import br.com.ewertoncorporation.boloscaseiros.model.TipoProduto;
import br.com.ewertoncorporation.boloscaseiros.service.TipoProdutoService;

@RestController
@RequestMapping("/tipoproduto")
public class TipoProdutoController implements ICrudController<TipoProduto>{
    TipoProdutoService service;
   @Autowired
    public TipoProdutoController(TipoProdutoService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<TipoProduto>> getAll() {
        List<TipoProduto> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TipoProduto> getById(@PathVariable("id") Long id) {
        TipoProduto registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<TipoProduto>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<TipoProduto> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<TipoProduto> insert(@RequestBody TipoProduto objeto) {
        TipoProduto registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<TipoProduto> update(@RequestBody TipoProduto objeto) {
        TipoProduto registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

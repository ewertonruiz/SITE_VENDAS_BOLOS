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

import br.com.ewertoncorporation.boloscaseiros.model.TipoUsuario;
import br.com.ewertoncorporation.boloscaseiros.service.TipoUsuarioService;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController implements ICrudController<TipoUsuario>{
    TipoUsuarioService service;
   @Autowired
    public TipoUsuarioController(TipoUsuarioService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<TipoUsuario>> getAll() {
        List<TipoUsuario> registro = service.getAll();
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TipoUsuario> getById(@PathVariable("id") Long id) {
        TipoUsuario registro = service.getById(id);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @GetMapping("/busca/{termoBusca}")
    public ResponseEntity<List<TipoUsuario>> getByAll(@PathVariable("termoBusca") String termoBusca) {
        List<TipoUsuario> registro = service.getByAll(termoBusca);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<TipoUsuario> insert(@RequestBody TipoUsuario objeto) {
        TipoUsuario registro = service.save(objeto);
       return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<TipoUsuario> update(@RequestBody TipoUsuario objeto) {
        TipoUsuario registro = service.save(objeto);
        return new ResponseEntity<>(registro, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.TipoUsuario;
import br.com.ewertoncorporation.boloscaseiros.repository.TipoUsuarioRepository;



@Service
public class TipoUsuarioService implements ICrudService<TipoUsuario> {
    private final TipoUsuarioRepository repo;

    @Autowired
    public TipoUsuarioService(TipoUsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TipoUsuario> getAll() {
        return repo.findAll();
    }

    @Override
    public TipoUsuario getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<TipoUsuario> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public TipoUsuario save(TipoUsuario objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
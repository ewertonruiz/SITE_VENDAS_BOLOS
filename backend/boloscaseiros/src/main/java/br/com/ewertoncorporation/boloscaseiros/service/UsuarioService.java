package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Usuario;
import br.com.ewertoncorporation.boloscaseiros.repository.UsuarioRepository;



@Service
public class UsuarioService implements ICrudService<Usuario> {
    private final UsuarioRepository repo;

    @Autowired
    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Usuario> getAll() {
        return repo.findAll();
    }

    @Override
    public Usuario getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Usuario save(Usuario objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
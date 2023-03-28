package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Receita;
import br.com.ewertoncorporation.boloscaseiros.repository.ReceitaRepository;



@Service
public class ReceitaService implements ICrudService<Receita> {
    private final ReceitaRepository repo;

    @Autowired
    public ReceitaService(ReceitaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Receita> getAll() {
        return repo.findAll();
    }

    @Override
    public Receita getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Receita> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Receita save(Receita objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
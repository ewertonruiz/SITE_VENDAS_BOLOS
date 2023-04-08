package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Bolo;
import br.com.ewertoncorporation.boloscaseiros.repository.BoloRepository;



@Service
public class BoloService implements ICrudService<Bolo> {
    private final BoloRepository repo;

    @Autowired
    public BoloService(BoloRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Bolo> getAll() {
        return repo.findAll();
    }

    @Override
    public Bolo getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Bolo> getByAll(String termoBusca) {

        return null;
    }

    @Override
    public Bolo save(Bolo objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
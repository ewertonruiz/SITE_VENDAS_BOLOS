package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Igrediente;
import br.com.ewertoncorporation.boloscaseiros.repository.IgredienteRepository;



@Service
public class IgredienteService implements ICrudService<Igrediente> {
    private final IgredienteRepository repo;

    @Autowired
    public IgredienteService(IgredienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Igrediente> getAll() {
        return repo.findAll();
    }

    @Override
    public Igrediente getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Igrediente> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Igrediente save(Igrediente objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
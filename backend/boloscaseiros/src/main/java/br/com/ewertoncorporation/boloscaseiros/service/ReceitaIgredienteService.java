package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.ReceitaIgrediente;
import br.com.ewertoncorporation.boloscaseiros.repository.ReceitaIgredienteRepository;



@Service
public class ReceitaIgredienteService implements ICrudService<ReceitaIgrediente> {
    private final ReceitaIgredienteRepository repo;

    @Autowired
    public ReceitaIgredienteService(ReceitaIgredienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<ReceitaIgrediente> getAll() {
        return repo.findAll();
    }

    @Override
    public ReceitaIgrediente getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<ReceitaIgrediente> getByAll(String termoBusca) {

        return null;
    }

    @Override
    public ReceitaIgrediente save(ReceitaIgrediente objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.UnidadeMedida;
import br.com.ewertoncorporation.boloscaseiros.repository.UnidadeMedidaRepository;



@Service
public class UnidadeMedidaService implements ICrudService<UnidadeMedida> {
    private final UnidadeMedidaRepository repo;

    @Autowired
    public UnidadeMedidaService(UnidadeMedidaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<UnidadeMedida> getAll() {
        return repo.findAll();
    }

    @Override
    public UnidadeMedida getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<UnidadeMedida> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public UnidadeMedida save(UnidadeMedida objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
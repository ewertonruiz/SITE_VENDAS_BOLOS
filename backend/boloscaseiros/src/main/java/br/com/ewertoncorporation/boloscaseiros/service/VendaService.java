package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Venda;
import br.com.ewertoncorporation.boloscaseiros.repository.VendaRepository;



@Service
public class VendaService implements ICrudService<Venda> {
    private final VendaRepository repo;

    @Autowired
    public VendaService(VendaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Venda> getAll() {
        return repo.findAll();
    }

    @Override
    public Venda getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Venda> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Venda save(Venda objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Vendedor;
import br.com.ewertoncorporation.boloscaseiros.repository.VendedorRepository;



@Service
public class VendedorService implements ICrudService<Vendedor> {
    private final VendedorRepository repo;

    @Autowired
    public VendedorService(VendedorRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Vendedor> getAll() {
        return repo.findAll();
    }

    @Override
    public Vendedor getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Vendedor> getByAll(String termoBusca) {

        return null;
    }

    @Override
    public Vendedor save(Vendedor objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
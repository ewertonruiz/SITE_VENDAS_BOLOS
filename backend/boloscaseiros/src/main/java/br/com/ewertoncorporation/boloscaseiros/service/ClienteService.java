package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Cliente;
import br.com.ewertoncorporation.boloscaseiros.repository.ClienteRepository;



@Service
public class ClienteService implements ICrudService<Cliente> {
    private final ClienteRepository repo;

    @Autowired
    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Cliente> getAll() {
        return repo.findAll();
    }

    @Override
    public Cliente getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> getByAll(String termoBusca) {
        return null;
    }

    @Override
    public Cliente save(Cliente objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
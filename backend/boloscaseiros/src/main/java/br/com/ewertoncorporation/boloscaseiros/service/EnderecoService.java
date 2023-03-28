package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Endereco;
import br.com.ewertoncorporation.boloscaseiros.repository.EnderecoRepository;



@Service
public class EnderecoService implements ICrudService<Endereco> {
    private final EnderecoRepository repo;

    @Autowired
    public EnderecoService(EnderecoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Endereco> getAll() {
        return repo.findAll();
    }

    @Override
    public Endereco getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Endereco> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Endereco save(Endereco objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
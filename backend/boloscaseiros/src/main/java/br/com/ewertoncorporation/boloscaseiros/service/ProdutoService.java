package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.Produto;
import br.com.ewertoncorporation.boloscaseiros.repository.ProdutoRepository;



@Service
public class ProdutoService implements ICrudService<Produto> {
    private final ProdutoRepository repo;

    @Autowired
    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Produto> getAll() {
        return repo.findAll();
    }

    @Override
    public Produto getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Produto> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public Produto save(Produto objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
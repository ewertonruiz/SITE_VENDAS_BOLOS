package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.TipoProduto;
import br.com.ewertoncorporation.boloscaseiros.repository.TipoProdutoRepository;



@Service
public class TipoProdutoService implements ICrudService<TipoProduto> {
    private final TipoProdutoRepository repo;

    @Autowired
    public TipoProdutoService(TipoProdutoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TipoProduto> getAll() {
        return repo.findAll();
    }

    @Override
    public TipoProduto getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<TipoProduto> getByAll(String termoBusca) {

        return repo.findByAll(termoBusca);
    }

    @Override
    public TipoProduto save(TipoProduto objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
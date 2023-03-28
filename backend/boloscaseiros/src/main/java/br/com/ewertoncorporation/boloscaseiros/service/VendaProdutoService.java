package br.com.ewertoncorporation.boloscaseiros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ewertoncorporation.boloscaseiros.model.VendaProduto;
import br.com.ewertoncorporation.boloscaseiros.repository.VendaProdutoRepository;



@Service
public class VendaProdutoService implements ICrudService<VendaProduto> {
    private final VendaProdutoRepository repo;

    @Autowired
    public VendaProdutoService(VendaProdutoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<VendaProduto> getAll() {
        return repo.findAll();
    }

    @Override
    public VendaProduto getById(Long id) {

        return repo.findById(id).orElse(null);
    }

    @Override
    public List<VendaProduto> getByAll(String termoBusca) {

        return null;
    }

    @Override
    public VendaProduto save(VendaProduto objeto) {

        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}
package br.com.ewertoncorporation.boloscaseiros.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ICrudController<T> {

    public ResponseEntity<List<T>> getAll();
    public ResponseEntity<T> getById(Long id);
    public ResponseEntity<List<T>> getByAll(String termoBusca);
    public ResponseEntity<T> insert(T objeto);
    public ResponseEntity<T> update(T objeto);
    public ResponseEntity<?> delete(Long id);
    
}

package com.hc.app.service;

import com.hc.app.model.LivroModel;
import com.hc.app.repository.LivroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRespository respository;

    public List<LivroModel> findAll(){
        return this.respository.findAll();
    }

    public LivroModel create(LivroModel livro){
        return this.respository.save(livro);
    }

    public Optional<LivroModel> update(Long id, LivroModel livro){
        return this.respository.findById(id)
                .map(livroModel -> {
                    livroModel.setAutor(livro.getAutor());
                    livroModel.setTitulo(livro.getTitulo());
                    return this.respository.save(livroModel);
                });
    }

}

package com.hc.app.controller;

import com.hc.app.model.LivroModel;
import com.hc.app.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livro){
        LivroModel response = this.service.create(livro);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll(){
        List<LivroModel> response = this.service.findAll();
        if (!response.isEmpty()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroModel> update(@PathVariable Long id, @RequestBody LivroModel livro){
        Optional<LivroModel> response = service.update(id, livro);
        if (response.isPresent()){
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



}

package br.com.futurodev.trabalho2.controllers;

import br.com.futurodev.trabalho2.model.Categoria;
import br.com.futurodev.trabalho2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping (value="/",produces="application/json")
    public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria){
        Categoria cate = categoriaRepository.save(categoria);
        return new ResponseEntity<Categoria>(cate, HttpStatus.CREATED);
    }

    @PutMapping(value="/", produces = "application/json")
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria){
        Categoria cate = categoriaRepository.save(categoria);
        return new ResponseEntity<Categoria>(cate, HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idCategoria){
        categoriaRepository.deleteById(idCategoria);
        return new ResponseEntity<String>("Classe deletada com sucesso!",HttpStatus.OK);
    }

    @GetMapping(value="/{idCategoria}", produces = "application/json")
    public ResponseEntity<Categoria>getCategoryById(@PathVariable(value = "idCategoria") Long idCategoria){
        Categoria cate = categoriaRepository.findById(idCategoria).get();
        return new ResponseEntity<Categoria>(cate, HttpStatus.OK);
    }
}

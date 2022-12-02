package br.com.futurodev.trabalho2.controllers;

import br.com.futurodev.trabalho2.model.Produto;
import br.com.futurodev.trabalho2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping (value="/",produces="application/json")
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto){
        Produto prod = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(prod, HttpStatus.CREATED);
    }

    @PutMapping(value="/", produces = "application/json")
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto){
        Produto prod = produtoRepository.save(produto);
        return new ResponseEntity<Produto>(prod, HttpStatus.OK);
    }

    @DeleteMapping(value="/")
    @ResponseBody
    public ResponseEntity<String> delete(@RequestParam Long idProduto){
        produtoRepository.deleteById(idProduto);
        return new ResponseEntity<String>("Produto deletado com sucesso!",HttpStatus.OK);
    }

    @GetMapping(value="/{idProduto}", produces = "application/json")
    public ResponseEntity<Produto>getProductById(@PathVariable(value = "idProduto") Long idProduto){
        Produto prod = produtoRepository.findById(idProduto).get();
        return new ResponseEntity<Produto>(prod, HttpStatus.OK);
    }
}

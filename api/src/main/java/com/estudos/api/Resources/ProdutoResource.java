package com.estudos.api.Resources;

import com.estudos.api.Models.Produtos;
import com.estudos.api.Repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produtos>listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna o produto referente ao ID passado como parametro")
    public Produtos listarProdutosunico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value="Salva o produto no banco de dados")
    public Produtos salvarProduto(@RequestBody Produtos produto){ return produtoRepository.save(produto);}

    @DeleteMapping("/produto")
    @ApiOperation(value="Deleta o produto no banco de dados")
    public void deletarProduto(@RequestBody Produtos produto){produtoRepository.delete(produto);}

    @PutMapping("/produto")
    @ApiOperation(value="Atualiza o produto no banco de dados")
    public Produtos atualizarProduto(@RequestBody Produtos produto){ return produtoRepository.save(produto);}
}

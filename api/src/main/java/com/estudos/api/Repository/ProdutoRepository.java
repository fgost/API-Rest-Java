package com.estudos.api.Repository;

import com.estudos.api.Models.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

    Produtos findById(long id);

}

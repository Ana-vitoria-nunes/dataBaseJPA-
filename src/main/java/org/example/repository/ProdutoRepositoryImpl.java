package org.example.repository;

import org.example.infra.DAO;
import org.example.model.ProdutoModel;
import java.util.List;
import java.util.Optional;

public abstract class ProdutoRepositoryImpl {
    private DAO dao;
    public ProdutoRepositoryImpl(DAO dao) {
        this.dao = dao;
    }

    public void creatPerson(ProdutoModel person){
        dao.addPerson(person);
    }
    public Optional<ProdutoModel> findyPersonById(Long id){
        return dao.findPersonById(id);
    }
    public List<ProdutoModel> getAllProduto(){
        return dao.getAllPerson();
    }

    public abstract ProdutoModel criarProduto(ProdutoModel produto);

    public abstract ProdutoModel recuperarProdutoPorId(Long id);

    public abstract ProdutoModel atualizarProduto(ProdutoModel produto);

    public abstract void excluirProduto(Long id);
}
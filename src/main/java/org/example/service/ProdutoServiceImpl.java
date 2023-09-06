package org.example.service;
import org.example.model.ProdutoModel;
import org.example.repository.ProdutoRepositoryImpl;
import javax.persistence.EntityNotFoundException;
import java.util.List;
public class ProdutoServiceImpl {
    private ProdutoRepositoryImpl personRepository;

    public ProdutoServiceImpl(ProdutoRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }
    public void createProduto(ProdutoModel produto){
        personRepository.creatPerson(produto);
        System.out.println(produto.getNome()+" inserido(a) com sucesso!");
    }
    public ProdutoModel findProdutoById(Long id){
        return personRepository.findyPersonById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<ProdutoModel> getAllProduto(){
        return personRepository.getAllProduto();
    }
}
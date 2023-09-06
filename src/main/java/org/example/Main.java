package org.example;
import org.example.infra.DAO;
import org.example.model.ProdutoModel;
import org.example.repository.ProdutoRepositoryImpl;
import org.example.service.ProdutoServiceImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        DAO dao = new DAO();
        ProdutoRepositoryImpl personRepository = new ProdutoRepositoryImpl(dao) {
            @Override
            public ProdutoModel criarProduto(ProdutoModel produto) {
                return null;
            }

            @Override
            public ProdutoModel recuperarProdutoPorId(Long id) {
                return null;
            }

            @Override
            public ProdutoModel atualizarProduto(ProdutoModel produto) {
                return null;
            }

            @Override
            public void excluirProduto(Long id) {

            }
        };
        ProdutoServiceImpl personService = new ProdutoServiceImpl(personRepository);

        while (true){
            System.out.println("Digite a opcao desejada:\n1-Criar um produto\n2-Procurar produto pelo id\n3-Atualizar um produto\n4-Deletar um produto");
            switch (sc.next()) {
                case "1" -> {
                    ProdutoModel person = inputPerson();
                    personService.createProduto(person);
                }
                case "2" -> {
                    System.out.println("Digite o id:");
                    Long id = sc.nextLong();
                    System.out.println(personService.findProdutoById(id));
                }
                case "3" -> {
                    List<ProdutoModel> people = personService.getAllProduto();
                    people.forEach(System.out::println);
                }
                case "4" -> {
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida");
            }
        }

    }
    public static ProdutoModel inputPerson(){
        Scanner sc = new Scanner(System.in);
        ProdutoModel produto = new ProdutoModel();
        System.out.println("Digite o nome do produto:");
        produto.setNome(sc.next());
        System.out.println("Digite o preço:");
        produto.setPreco(sc.nextDouble());

        return produto;
    }
}
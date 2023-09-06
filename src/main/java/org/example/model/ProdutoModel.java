package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "preco", nullable = false)
    private double preco;


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", preço='" + preco + '\''+
                '}';
    }
}

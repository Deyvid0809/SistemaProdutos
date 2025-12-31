package grupologi.SistemaDeVenda.entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String nome;

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer estoque;

    public String getNome() {
        return nome;
    }
    
    public BigDecimal getPreco() {
        return preco;
    }
    public Integer getEstoque() {
        return estoque;
    }
    public Long getId() {
        return id;
    }

    public Produto(String nome, BigDecimal preco, Integer estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    public Produto() {
    // construtor vazio (Hibernate)
    }

}
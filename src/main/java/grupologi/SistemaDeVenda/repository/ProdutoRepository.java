package grupologi.SistemaDeVenda.repository;
import grupologi.SistemaDeVenda.entity.Produto;
import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoreCase(String nome);

    Optional<Produto> findByNome(String nome);

    boolean existsByNome(String nome);
    
}

package grupologi.SistemaDeVenda.Service;
import java.util.Optional;
import grupologi.SistemaDeVenda.Exceptions.ProdutoNaoEncontradoException;

import org.springframework.stereotype.Service;
import grupologi.SistemaDeVenda.repository.ProdutoRepository;
import grupologi.SistemaDeVenda.Request.ProdutoCreateRequest;
import grupologi.SistemaDeVenda.entity.Produto;


@Service
public class ProdutoService {
    
    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo){
        this.repo = repo;
    }

    public Long criar(ProdutoCreateRequest req){
        if(repo.existsByNome(req.nome())){
            throw new RuntimeException("Produto já existe");
        }

        Produto produto = new Produto(req.nome(), req.preco(), req.estoque());

        return repo.save(produto).getId();
    }

    public Produto buscarPorId(Long id){
        Optional<Produto> produtos = repo.findById(id);
        if (produtos.isEmpty()) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }

        return produtos.get();

    }

}

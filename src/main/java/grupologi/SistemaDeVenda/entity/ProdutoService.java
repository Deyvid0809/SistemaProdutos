package grupologi.SistemaDeVenda.entity;
import org.springframework.stereotype.Service;
import grupologi.SistemaDeVenda.repository.ProdutoRepository;
import grupologi.SistemaDeVenda.Request.ProdutoCreateRequest;


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

}

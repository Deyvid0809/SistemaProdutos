package grupologi.SistemaDeVenda.entity;
import grupologi.SistemaDeVenda.Request.ProdutoCreateRequest;
import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    
    private final ProdutoService service;

    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> criar(@Valid @RequestBody ProdutoCreateRequest request){
        Long id = service.criar(request);
        return ResponseEntity.created(URI.create("/produtos/" + id)).build();
    }


    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id){
        return service.buscarPorId(id);
    }


}
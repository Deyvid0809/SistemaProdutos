package grupologi.SistemaDeVenda.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler (ProdutoNaoEncontradoException.class)
    public ResponseEntity<String> tratar404(ProdutoNaoEncontradoException ex){
        return ResponseEntity
            .status(404)
            .body(ex.getMessage());
    }
    
}

package grupologi.SistemaDeVenda.Request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoCreateRequest(
    @NotBlank String nome,
    @NotNull @DecimalMin("0.01") BigDecimal preco,
    @NotNull @Min(0) Integer estoque
) {
}
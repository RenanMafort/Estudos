package venda;

import cliente.Cliente;
import lombok.Builder;
import lombok.Getter;
import vendedor.Vendedor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Getter
public class Venda {

    private final BigDecimal totalCompra;
    private final BigDecimal troco;
    private final Vendedor vendedor;

    private final Cliente cliente;

    @Builder.Default
    private final LocalDate dataVenda = LocalDate.now();

}

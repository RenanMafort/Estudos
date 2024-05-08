import bancodedados.BancoDeDados;
import compra.Compra;
import compra.Item;
import modelos.RegistradoraModelo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class RegistradoraTeste {
    @BeforeEach
    void reiniciarBancoDeDados(){
        BancoDeDados.reset();
    }
    @Test
    public void deveRegistrarAvendaNoBancoDeDados(){
        //Arrange -> tradução livre -> Entrada
        var pastelDeCarne = Item.builder().name("Pastel de Carne").value(new BigDecimal("8.00")).build();
        var pastelDeFrango = Item.builder().name("Pastel de Frango").value(new BigDecimal("5.50")).build();

        List<Item> itemList = Arrays.asList(pastelDeCarne,pastelDeFrango);

        var compra = Compra.builder().itemList(itemList).build();

        var registradora = RegistradoraModelo.construirCenario()
                .compra(compra)
                .valorRecebido(new BigDecimal("13.50"))
                .build();
        //Act -> tradução livre -> Ação
        registradora.efetivarVenda();
        //Assert -> tradução livre -> Resultado
        Assertions.assertEquals(1, BancoDeDados.vendas.size());
        Assertions.assertEquals(new BigDecimal("13.50"), BancoDeDados.vendas.get(0).getTotalCompra());
        Assertions.assertEquals("Jet li", BancoDeDados.vendas.get(0).getVendedor().getNome());
        Assertions.assertEquals("bruce lee", BancoDeDados.vendas.get(0).getCliente().getNome());
        Assertions.assertEquals(LocalDate.now(), BancoDeDados.vendas.get(0).getDataVenda());

    }

    @Test
    public void naoDeveRegistrarAVendaQuandoOValorRecebidoForMenorDoQueOTotal(){
        //Arrange -> tradução livre -> Entrada
        var pastelDeCarne = Item.builder().name("Pastel de Carne").value(new BigDecimal("8.00")).build();
        var pastelDeFrango = Item.builder().name("Pastel de Frango").value(new BigDecimal("5.50")).build();

        List<Item> itemList = Arrays.asList(pastelDeCarne,pastelDeFrango);

        var compra = Compra.builder().itemList(itemList).build();

        var registradora = RegistradoraModelo.construirCenario()
                .compra(compra)
                .valorRecebido(new BigDecimal("13.00"))
                .build();
        //Act -> tradução livre -> Ação
        registradora.efetivarVenda();
        //Assert -> tradução livre -> Resultado
        Assertions.assertEquals(0,BancoDeDados.vendas.size());

    }
}

import static org.junit.jupiter.api.Assertions.*;

import br.com.sereia.renan.exception.ExplosaoException;
import br.com.sereia.renan.model.Campo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CampoTest {
    private Campo campo ;

    @BeforeEach
    void iniciarCampos(){
        campo = new Campo(3,3);
    }

    @Test
    @DisplayName("testeVizinhoEsquerda")
    void testeVizinhoEsquerda(){
       Campo vizinho = new Campo(3,2);
        boolean result = campo.adicionharVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    @DisplayName("testeVizinhoDireita")
    void testeVizinhoDireita(){
        Campo vizinho = new Campo(3,4);
        boolean result = campo.adicionharVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    @DisplayName("testeVizinhoCima")
    void testeVizinhoCima(){
        Campo vizinho = new Campo(3,4);
        boolean result = campo.adicionharVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    @DisplayName("testeVizinhoBaixo")
    void testeVizinhoBaixo(){
        Campo vizinho = new Campo(3,4);
        boolean result = campo.adicionharVizinho(vizinho);
        assertTrue(result);
    }

    @Test
    @DisplayName("testeVizinhoDiagonais")
    void testeVizinhoDiagonais(){
        Campo diagonalEsquerdaCima = new Campo(2,2);
        Campo diagonalEsquerdaBaixo = new Campo(4,2);
        Campo diagonalDireitaCima = new Campo(2,4);
        Campo diagonalDireitaBaixo = new Campo(4,4);
        boolean result1 = campo.adicionharVizinho(diagonalEsquerdaCima);
        boolean result2 = campo.adicionharVizinho(diagonalEsquerdaBaixo);
        boolean result3 = campo.adicionharVizinho(diagonalDireitaCima);
        boolean result4 = campo.adicionharVizinho(diagonalDireitaBaixo);
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertTrue(result4);


        Campo diagonal = new Campo(6,8);
        boolean diagonal2 = campo.adicionharVizinho(diagonal);
        assertFalse(diagonal2);
    }

    @Test
    void testeValorPadraoAtributoMarcado(){
        assertFalse(campo.isMarcado());
    }
    @Test
    void testeAltenarMarcacao(){
        campo.alternarMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void testeAltenarMarcacaoDuplicado(){
        campo.alternarMarcacao();
        campo.alternarMarcacao();
        assertFalse(campo.isMarcado());
    }

    @Test
    void testeAbrirNaoMinadoNaoMarcado(){
        assertTrue(campo.abrir());

    }

    @Test
    void testeAbrirNaoMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());

    }

    @Test
    void testeAbrirMinadoMarcado(){
        campo.alternarMarcacao();
        campo.minar();
        assertFalse(campo.abrir());

    }

    @Test
    void testeAbrirMinadoNaoMarcado(){
        campo.minar();
        assertThrows(ExplosaoException.class,() -> campo.abrir());

    }

}

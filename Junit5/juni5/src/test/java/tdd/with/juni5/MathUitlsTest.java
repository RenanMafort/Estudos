package tdd.with.juni5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static tdd.with.juni5.MathUitls.mdc;

class MathUitlsTest {
    @Test
     void testMdcAPar(){
        final int a = 6;
        final int b = 3;
        final int esperado = b;
        final int obtido = MathUitls.mdc(a, b);

        Assertions.assertEquals(esperado,obtido);
    }

    @Test
    void testAImpar(){
        final int a = 9;
        final int b = 3;
        final int esperado = b;
        final int obtido = MathUitls.mdc(a,b);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP2(){
        final int a = 16;
        final int b = 8;
        final int divisor = 4;
        final int obtido = MathUitls.mdc(a,b);

//        assertEquals(esperado, obtido % divisor);
        assertTrue(obtido % divisor ==0);
    }

    @Test
    void testMdABPositivoP3(){
        final int a = 15;
        final int b = 0 ;
        final int obtido = MathUitls.mdc(a,b);
        final int esperado = 15;
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcANegativop3(){
        final int a = -30;
        final int b = 0;
        final int esperado = 30;
        final int obtido = MathUitls.mdc(a,b);
        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcParP4(){
        final int a = 9;
        final int b = 3;
        final int m = 2;
        //mdc(a*m,b*m) = m * mdc(a,b)
        //mdc(18,6) == 2 * mdc(9,3)

        final int esperado = MathUitls.mdc(a*m,b*m);
        final int obtido = m * MathUitls.mdc(a,b);
        assertEquals(esperado,obtido);

    }

    @Test
    void testMdcP5(){
        final int a = 7;
        final int b = 3;
        final int c = 5;
        final int esperado = mdc(a*b,c);
        final int obtido = mdc(b,c);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP6(){
        final int a = 8 ;
        final int b = 2;
        final int esperado = mdc(a,b);
        final int obtido = mdc(b,a);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP7TudoNegativo(){
        final int a = -12 ;
        final int b = -6 ;
        final int esperado = 6 ;
        final int obtido = mdc(a,b) ;
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcGeralIndivisiveis(){
        final int a = 30;
        final int b = 12;
        final int esperado = 6;
        final int obtido = mdc(a,b);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcMultiplosValores(){
        final int a = 30;
        final int b = 12;
        final int c = 4;
        final int esperado = 2;
        final int obtido = mdc(a,b,c);
        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcNenhumParametro(){
        assertThrows(IllegalArgumentException.class,() -> mdc());
    }

    @Test
    void testNull(){
       assertThrows(NullPointerException.class,() -> mdc(null));
    }

}
package features.java.java15.reflexao;

import java.lang.reflect.Field;

/**
 * @author Renan Sereia
 * @date 08/07/2025
 */

 class Produto {
    private  int codigo = 1342;

    public int getCodigo() {
        return codigo;
    }
}

public class Teste {
    public static void main(String[] args) {
        Produto produto = new Produto();
        System.out.println(produto.getCodigo());

        try{
            //Obter o atributo(field) da classe
            Field field = produto.getClass().getDeclaredField("codigo");

            field.setAccessible(true);

            field.set(produto, 2543);

            System.out.println(produto.getCodigo());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

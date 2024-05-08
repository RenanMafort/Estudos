package br.com.devdojo.varargs.wrappers;

public class StringPerformarceTeste {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(100_000);
        long fim = System.currentTimeMillis();
        System.out.println("String : " + (fim - inicio) + "ms");

        long inicio1 = System.currentTimeMillis();
        concatStringBuilder(100_000);
        long fim1 = System.currentTimeMillis();
        System.out.println("StringBuider : " + (fim1 - inicio1) + "ms");

        long inicio2 = System.currentTimeMillis();
        concatStringBuffer(100_000);
        long fim2 = System.currentTimeMillis();
        System.out.println("StringBuffer : " + (fim2 - inicio2) + "ms");

    }
    private static void concatString(int tamanho){
        String text = "";
        for (int i = 0; i <tamanho ; i++) {
            text+=i;
        }
    }

    private static void concatStringBuilder(int tamanho){
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i <tamanho ; i++) {
            sb.append(i);
        }
    }

    private static void concatStringBuffer(int tamanho){
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i <tamanho ; i++) {
            sb.append(i);
        }
    }
}

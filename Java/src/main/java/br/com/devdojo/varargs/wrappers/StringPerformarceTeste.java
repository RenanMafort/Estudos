package br.com.devdojo.varargs.wrappers;

public class StringPerformarceTeste {
    public static void main(String[] args) {
        String text = "1";
        System.out.println(text.length());

        System.out.println(text.length());

//
//        int i = 0, sa = 2;
//        long inicio = System.currentTimeMillis();
//        concatString(100_000);
//        long fim = System.currentTimeMillis();
//        System.out.println("String : " + (fim - inicio) + "ms");
//
//        long inicio1 = System.currentTimeMillis();
//        concatStringBuilder((int)100_000L);
//        concatStringBuilder(Integer.parseInt(String.valueOf(100_000L)));
//        long fim1 = System.currentTimeMillis();
//        System.out.println("StringBuider : " + (fim1 - inicio1) + "ms");
//
//        long inicio2 = System.currentTimeMillis();
//        concatStringBuffer(100_000);
//        long fim2 = System.currentTimeMillis();
//        System.out.println("StringBuffer : " + (fim2 - inicio2) + "ms");

        int limit = -Integer.MAX_VALUE;
        int limit2 = Integer.MAX_VALUE;
        System.out.println(limit);
        System.out.println(limit2);

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

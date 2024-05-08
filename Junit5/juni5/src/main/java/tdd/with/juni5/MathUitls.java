package tdd.with.juni5;

public class MathUitls {
    public static int mdc(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        if ((b > 0) && (a % b == 0)){
                return b;
        }

        if (b == 0){
            return Math.abs(a);
        }


        return mdc(a-b,b);
    }

    public static int mdc(int ...valores){
        if (valores.length == 0){
            throw new IllegalArgumentException("O vetor está vazio");
        }
        int a = valores[0];
        for (int b: valores) {
           a = mdc(a,b);
        }

        return a;
    }
}

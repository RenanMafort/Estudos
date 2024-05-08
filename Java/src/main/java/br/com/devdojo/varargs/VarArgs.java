package br.com.devdojo.varargs;

public class VarArgs {
    public void somar(double num2,int... nums){
        int soma = 0 + (int)num2;
        for (int i: nums ) {
            soma+=i;
        }
        System.out.println(soma);

    }

    public static void main(String[] args) {
        VarArgs var = new VarArgs();
        int[] array = {1,2,3,4,5,6,7,8,9};

        var.somar(0,array);
        var.somar(1,4,5,6,7,8);


    }
}

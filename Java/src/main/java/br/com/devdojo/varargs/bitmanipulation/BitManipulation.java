package br.com.devdojo.varargs.bitmanipulation;

public class BitManipulation {
    public static final int READ = 1;    // 0001
    public static final int WRITE = 2;   // 0010
    public static final int EXECUTE = 4; // 0100

    public static void main(String[] args) {
        int permissions = 0;

        // Adiciona permissões
        permissions |= READ;
        permissions |= WRITE;

        // Verifica permissões
        System.out.println("Tem READ? " + ((permissions & READ) != 0));      // true
        System.out.println("Tem EXECUTE? " + ((permissions & EXECUTE) != 0));// false

        // Remove WRITE
        permissions &= ~WRITE;

        System.out.println("Tem WRITE? " + ((permissions & WRITE) != 0));    // false

        // Toggle EXECUTE
        permissions ^= EXECUTE;

        System.out.println("Tem EXECUTE? " + ((permissions & EXECUTE) != 0));// true


        int a = 5; // 0101
        int b = 3; // 0011

        System.out.println("a & b = " + Integer.toBinaryString(a & b)); // 0001
        System.out.println("a | b = " + Integer.toBinaryString(a | b)); // 0111
        System.out.println("a ^ b = " + Integer.toBinaryString(a ^ b)); // 0110
        System.out.println("~a    = " + Integer.toBinaryString(~a));    // Inverso
        System.out.println("~b    = " + Integer.toBinaryString(~b));    // Inverso

        int testando = 0;
        testando = testando | 5;

        System.out.println(Integer.toBinaryString(testando));
    }
}

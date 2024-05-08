package br.com.devdojo.varargs.crudjdbc.test;

import br.com.devdojo.varargs.crudjdbc.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            menuProducer();
           op = SCANNER.nextInt();
            if (op ==0 )break;
           ProducerService.buildMenu(op);
        }
    }

    private static void menuProducer() {
        System.out.println("Type the number of your operation");
        System.out.println("1. Serach for producer");
        System.out.println("2. Delete producer");
        System.out.println("3. Save producer");
        System.out.println("4. Update producer");
        System.out.println("0. Exite");
    }
}

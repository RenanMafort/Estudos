package br.com.devdojo.varargs.classesinternas;

public class OuterClasses02 {
    private final String name = "Renan";

    void print(){
        String lastName = "Sereia";

        class LocalClass{
            protected static String teste = "hello";
            public void printLocal(){
                System.out.println(name + " " + lastName);
            }
        }

        new LocalClass().printLocal();
    }

    public static void main(String[] args) {
        OuterClasses02 outer = new OuterClasses02();
        outer.print();

    }
}

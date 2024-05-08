package br.com.devdojo.varargs.classesinternas;

public class OuterClasses03 {
    private String name;
    static class Nested{
        void print(){
            System.out.println(new OuterClasses03().name);
        }
    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();


    }
}

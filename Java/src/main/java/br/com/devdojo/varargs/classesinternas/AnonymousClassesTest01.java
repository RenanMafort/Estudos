package br.com.devdojo.varargs.classesinternas;

class Animal{
    public void walk(){
        System.out.println("Animal walking");
    }

    public void print(){
        System.out.println("Printando na classe animal!");
    }
}

class Dog extends Animal{
    @Override
    public void walk() {
        System.out.println("Cachorro walking");
    }
}
public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal(){

            @Override
            public void print() {
               super.print();
                testE();
            }

            public void testE(){
                System.out.println("teste");
            }
        };
        Dog animal2 = new Dog(){
            @Override
            public void walk() {
                super.walk();
            }
        };
//        animal.walk();
//        animal2.walk();

        animal.print();

    }
}

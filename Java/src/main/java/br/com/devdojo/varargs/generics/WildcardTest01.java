package br.com.devdojo.varargs.generics;

abstract class Animal extends Mamifero{ // extends = É
    public abstract void consuta();
}

class Cachorro extends Animal{ //extends = É

    @Override
    public void consuta() {
        System.out.println("Consultando cachorro");
    }
}

class Gato extends Animal{

    @Override
    public void consuta() {
        System.out.println("Consultando gato! ");
    }
}
public class WildcardTest01 {

    public static void main(String[] args) {
        Cachorro[] cachorros = {new Cachorro(),new Cachorro()};
        Gato[] gatos = {new Gato(),new Gato()};
        Animal[] animals = {new Cachorro(),new Gato()};
        printConsulta(cachorros);
        printConsulta(gatos);
        printConsulta(animals);

    }

    private static void printConsulta(Animal[] animals){
        for (Animal animal : animals){
            animal.consuta();
        }

//        animals[0] = new Cachorro();
    }
}


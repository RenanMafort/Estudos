package br.com.devdojo.varargs.comportamento.dominio.interfaces;

import br.com.devdojo.varargs.comportamento.dominio.Car;

public interface CarPredicate {
    boolean test(Car car);
    //(parametro) -> <expressão>
    //(Car car) -> car.getColor.equals("green")
}

package br.com.devdojo.varargs.comportamento.dominio.test;

import br.com.devdojo.varargs.comportamento.dominio.Car;
import br.com.devdojo.varargs.comportamento.dominio.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(
            new Car("green",2011),
            new Car("red",2020),
            new Car("blue",2025));

    public static void main(String[] args) {
//        List<Car> greenCars = filter(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("green");
//            }
//        });


        List<Car> greenCars = filter(cars, car -> car.getColor().equals("green"));
        List<Car> carsAge = filter(cars, (car) -> car.getYear() < 2022);
        System.out.println(greenCars);
        System.out.println(carsAge);

    }
    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate){
        List<Car> filter = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)){
                filter.add(car);
            }
        }
        return filter;
    }



}

package br.com.devdojo.varargs.comportamento.dominio.test;

import br.com.devdojo.varargs.comportamento.dominio.Car;
import br.com.devdojo.varargs.comportamento.dominio.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
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
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println(filter(nums,n -> n %2 == 0));

    }
    private static <T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> filteredList = new ArrayList<>();

        for (T e : list){
            if (predicate.test(e)){
                filteredList.add(e);
            }
        }
        return filteredList;
    }

    

}

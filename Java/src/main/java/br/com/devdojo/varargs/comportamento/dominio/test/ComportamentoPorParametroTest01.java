package br.com.devdojo.varargs.comportamento.dominio.test;

import br.com.devdojo.varargs.comportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    public static void main(String[] args) {
        System.out.println(filterGreenCar(cars));
        System.out.println(filterRedCar(cars));
        System.out.println(filterCarByColor(cars,"blue"));
        System.out.println(filterCarByColor(cars,"yelow"));
        System.out.println(filterCarByAge(cars,2022));

    }
    private static List<Car> cars = List.of(
            new Car("green",2011),
            new Car("red",2020),
            new Car("blue",2025));
    private static List<Car> filterGreenCar(List<Car> cars){
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("green")){
                greenCars.add(car);
            }
        }
        return greenCars;
    }
    private static List<Car> filterRedCar(List<Car> cars){
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("red")){
                greenCars.add(car);
            }
        }
        return greenCars;
    }

    private static List<Car> filterCarByColor(List<Car> cars,String color){
        List<Car> colors = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)){
                colors.add(car);
            }
        }
        return colors;
    }

    private static List<Car> filterCarByAge(List<Car> cars,int year){
        List<Car> age = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year){
                age.add(car);
            }
        }
        return age;
    }

}

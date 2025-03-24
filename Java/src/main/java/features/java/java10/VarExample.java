package features.java.java10;

import java.util.List;

public class VarExample {

    public static void main(String[] args) {
        String lastName = "Mundo!";
        var name = "Olá";
        System.out.println(name);
        System.out.println(lastName);

        var list = List.of(1,2,3,4,5,6,7,8,9);

        for (var l: list){
            System.out.println(l);
        }

        for (var i=0;i< list.size();i++);

        var ae = new ArrayIndexOutOfBoundsException();


    }
}

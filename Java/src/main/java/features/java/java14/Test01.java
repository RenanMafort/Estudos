package features.java.java14;

record Records(String name, Integer idade) {


}

public class Test01{
    public static void main(String[] args) {
        Records records = new Records("Renan",22);

        System.out.println(records.idade());
        System.out.println(records.name());
    }
}

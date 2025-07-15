package br.com.devdojo.varargs.records;

public class RecordTest {
    public static void main(String[] args) {
        Records r = new Records("Renan",22);
        r.notifyAll();
        Records r1 = new Records("Renan",22);
        System.out.println(r.name());
        System.out.println(r.age());

        System.out.println(r.equals(r1));
    }
}

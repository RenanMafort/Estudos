package features.java.java14.instanceoff;

public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        if (o instanceof String s) {
            int length = s.length();
        }
    }
}

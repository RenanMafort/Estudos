package features.java.java11;

public class Test01 {
    public static void main(String[] args) {
        String one = "   ";
        String two = "";
        String tree = "Hello world";

        System.out.println(one.isBlank());
        System.out.println(two.isBlank());
        System.out.println(tree.isBlank());

        String linebreak = "Olá\n tudo bem?\n anana\n akasdk";
        System.out.println(linebreak.lines().toList());

        String repeat = "Repetinho.. ";
        System.out.println(repeat.repeat(2));

    }
}

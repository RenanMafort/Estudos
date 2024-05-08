package br.com.devdojo.varargs.classesinternas;

public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    class Inner{
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println(this.getClass().getClass().getClass().getName());
            System.out.println(OuterClassesTest01.this);
        }
    }

    public static void main(String[] args) {
        OuterClassesTest01 outerClassesTest01 =  new OuterClassesTest01();
        Inner inner = outerClassesTest01.new Inner();
        Inner inner1 = new OuterClassesTest01().new Inner();
        inner.printOuterClassAttribute();
        inner1.printOuterClassAttribute();
    }

}

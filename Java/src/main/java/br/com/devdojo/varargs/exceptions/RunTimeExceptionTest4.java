package br.com.devdojo.varargs.exceptions;

public class RunTimeExceptionTest4 {
    public static void main(String[] args) {
        try {
            String name = "Renan";
            System.out.println(name.charAt(20));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        }catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("StringIndexOutOfBoundsException");
        }catch (IndexOutOfBoundsException e){
            System.out.println("IndexOutOfBoundsException");
        }catch (IllegalArgumentException e){
            System.out.println("IllegalArgumentException");
        }
    }
}

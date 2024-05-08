package br.com.springboot3.utils;

public class NumberConteverter {

    public static Double convertDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    public static boolean isNumeric(String number) {
        if (number == null) return false;
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}

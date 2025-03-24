package br.com.devdojo.varargs.validaDataAno;

public class Validate {
    public static boolean isDataValida(String data) {
        // Verifica se a data tem o formato correto
        if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }

        // Obtém o dia, mês e ano da data
        int dia = Integer.parseInt(data.substring(0, 2));
        int mes = Integer.parseInt(data.substring(3, 5));
        int ano = Integer.parseInt(data.substring(6));

        // Verifica se o ano é bissexto
        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        // Verifica se o mês é válido e se o dia está dentro do limite para o mês
        switch (mes) {
            case 1:  // janeiro
            case 3:  // março
            case 5:  // maio
            case 7:  // julho
            case 8:  // agosto
            case 10: // outubro
            case 12: // dezembro
                return dia >= 1 && dia <= 31;
            case 4:  // abril
            case 6:  // junho
            case 9:  // setembro
            case 11: // novembro
                return dia >= 1 && dia <= 30;
            case 2:  // fevereiro
                if (bissexto) {
                    return dia >= 1 && dia <= 29;
                } else {
                    return dia >= 1 && dia <= 28;
                }
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isDataValida("99/02/2023"));
    }
}

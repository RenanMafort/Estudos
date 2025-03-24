package features.java.java12;

public class SwitchCases {

    public static void main(String[] args) {
        String dia = "Domingo";

        var resultado = switch (dia){
            case "Segunda","Terça","Quarta","Quinta","Sexta" -> "Dia útil";
            case "Sabado","Domingo" -> "Final de semana";
            default -> "Dia invalido";
        };

        System.out.println(resultado);
    }
}

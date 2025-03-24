package features.java.java13;

public class SwitchCases {

    public static void main(String[] args) {
        String dia = "Domingo";

        var resultado = switch (dia){
            case "Segunda","Terça","Quarta","Quinta","Sexta":
                yield "Dia útil";
            case "Sabado","Domingo":
                yield "Final de semana";
            default:
                yield "Dia invalido";
        };

        System.out.println(resultado);
    }
}

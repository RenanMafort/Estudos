package br.com.devdojo.varargs.associacao.muitospramuitos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JogadorTest {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Renan");
        Jogador jogador1 = new Jogador("Renan");
        Jogador jogador2 = new Jogador("Renan");
        Time time = new Time("São Paulo");
        Time time1 = new Time("São Paulo1");
        Time time2 = new Time("São Paulo2");
        jogador1.setTime(List.of(time));
        jogador1.setTime(List.of(time,time1,time,time2));
        List<Jogador> jogador3 = List.of(jogador, jogador1, jogador2);

        jogador3.forEach(System.out::println);
    }
}

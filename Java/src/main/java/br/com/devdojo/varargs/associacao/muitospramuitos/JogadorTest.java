package br.com.devdojo.varargs.associacao.muitospramuitos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JogadorTest {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Renan");
        Time time = new Time("São Paulo");
        List<Jogador> jogador1 = List.of(jogador);
//        time.setJogadores();
    }
}

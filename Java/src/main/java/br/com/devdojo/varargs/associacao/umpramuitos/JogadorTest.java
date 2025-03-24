package br.com.devdojo.varargs.associacao.umpramuitos;

public class JogadorTest {
    public static void main(String[] args) {
        Jogador jogador = new Jogador("Renan");
        Time time = new Time("São Paulo");

        jogador.imprime();
        jogador.setTime(time);
        jogador.imprime();
    }
}

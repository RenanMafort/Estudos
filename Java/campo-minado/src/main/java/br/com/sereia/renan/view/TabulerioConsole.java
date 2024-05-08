package br.com.sereia.renan.view;

import br.com.sereia.renan.exception.ExplosaoException;
import br.com.sereia.renan.exception.SairException;
import br.com.sereia.renan.model.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabulerioConsole {

    private Tabuleiro tabuleiro;
    private Scanner scanner = new Scanner(System.in);

    public TabulerioConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;
            while (continuar){
                cicloJogo();
                System.out.println("Outra partida? (S/n) ");
                String resposta = scanner.nextLine();
                if ("n".equalsIgnoreCase(resposta)){
                    continuar = false;
                }else {
                    tabuleiro.reinicar();
                }
            }
        }catch (SairException e){
            System.out.println("Tchauu...");
        }finally {
            scanner.close();
        }
    }

    private void cicloJogo(){
        try {
            while (!tabuleiro.objetivoAlcancado()){
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado("Digite (x,y):" );
                Iterator<Integer> iterator = Arrays.stream(digitado.split(","))
                        .map(v -> Integer.parseInt(v.trim())).iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Desmarcar)");
                if ("1".equals(digitado)){
                    tabuleiro.abrir(iterator.next(), iterator.next());
                } else if ("2".equals(digitado)) {
                    tabuleiro.alterMarcacao(iterator.next(),iterator.next());
                }
            }
            System.out.println("Você Ganhou!");
        }catch (ExplosaoException e){
            System.out.println(tabuleiro);
            System.out.println("Você Perdeu!");
        }
    }

    private String capturarValorDigitado(String texto){
        System.out.print(texto);
        String digitado = scanner.nextLine();
        if ("sair".equalsIgnoreCase(digitado)){
            throw new SairException();
        }
        return digitado;
    }
}

package br.com.sereia.renan.main;

import br.com.sereia.renan.model.Tabuleiro;
import br.com.sereia.renan.view.TabulerioConsole;

public class Aplicacao {
    public static void main(String[] args) {
        new TabulerioConsole(new Tabuleiro(6,6,3));
    }
}

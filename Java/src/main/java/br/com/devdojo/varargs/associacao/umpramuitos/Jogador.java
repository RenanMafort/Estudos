package br.com.devdojo.varargs.associacao.umpramuitos;

public class Jogador {
    private String nome;

    private Time time;


    public Jogador(String nome) {
        this.nome = nome;
    }

    public void imprime(){
        if (this.time != null){
            System.out.println(time.getNome());
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}

package br.com.devdojo.varargs.blocodeinicializacao;

public class BlocosDeInicializacao {
    private String nome;
    private int idade;
    private double altura;

    //STATIC PERTENCE A CLASSE DO OBJETO 'BlocosDeInicializacao'
    private static double peso ;

    //É executado apenas uma vez independente de quantas instâncias foram criadas
    static  {
        System.out.println("Entrou no bloco de inicialização");
    }

    public BlocosDeInicializacao(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public static void setPeso(double peso){
        BlocosDeInicializacao.peso = peso;
    }
    public static double getPeso(){
        return BlocosDeInicializacao.peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "BlocosDeInicializacao{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}

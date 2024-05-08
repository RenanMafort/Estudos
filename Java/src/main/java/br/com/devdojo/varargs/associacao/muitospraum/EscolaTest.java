package br.com.devdojo.varargs.associacao.muitospraum;

public class EscolaTest {
    public static void main(String[] args) {
        Escola escola = new Escola("Presidente Kennedy");
        Professor professor = new Professor("Renan Sereia");
        Professor professor2 = new Professor("Juliu Alvez");
        Professor professor3 = new Professor("Maria do Bairro");
        Professor professor4 = new Professor("Gege Sasoo");
        Professor[] professors = new Professor[]{professor,professor2,professor3,professor4};
        escola.setProfessores(professors);

        escola.imprime();
    }


}

package features.java.java18;

/**
 * @author Renan Sereia
 * @date 11/07/2025
 */
public class JavaDocs {
    private String nome;
    private String sobreNome;

    public JavaDocs() {
    }

    /**
     *  Construtor da classe JavaDoc
     *  {@snippet :
     *    public JavaDocs(String nome, String sobreNome) {
     *         this.nome = nome;
     *         this.sobreNome = sobreNome;
     *     }
     * }
     */
    public JavaDocs(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}

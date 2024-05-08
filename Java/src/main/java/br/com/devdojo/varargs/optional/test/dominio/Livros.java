package br.com.devdojo.varargs.optional.test.dominio;

public class Livros {
    private Integer id = 0;
    private String title;
    private int paginas;

    public Livros(String title, int paginas) {
        this.id +=1;
        this.title = title;
        this.paginas = paginas;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

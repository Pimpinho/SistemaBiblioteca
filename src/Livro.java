public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private String categoria;
    private int paginas;
    private boolean disponivel;

    public Livro(String id, String titulo, String autor, String categoria, int paginas) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.paginas = paginas;
        this.disponivel = true;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public String toString() {
        return  "> " +titulo + " | " +
                "Autor = " + autor + " | " +
                "Categoria = " + categoria + " | " +
                "Páginas = " + paginas + " | " +
                "ID = " + id + "\n";
     }

}

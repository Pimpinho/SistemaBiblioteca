public class Usuario {
    private String nome;
    public Livro livroAlugado;

    public Usuario(String nome) {
        this.nome = nome;
        this.livroAlugado = null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Livro getLivroAlugado() {
        return livroAlugado;
    }

    public void setLivroAlugado(Livro livroAlugado) {
        this.livroAlugado = livroAlugado;
    }

    public void alugarLivro(Livro livro) {
        if (livro.isDisponivel()) {
            livroAlugado = livro;
            livro.setDisponivel(false);

            System.out.println(nome + " alugou o livro " + livro.getTitulo());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível!" );
        }
    }
    public void devolverLivro(Livro livro) {
        if (livroAlugado != null) {
            livroAlugado.setDisponivel(true);
            System.out.println(nome + " devolveu o livro " + livro.getTitulo());
            livroAlugado = null;

        } else {
            System.out.println(nome + " não há nenhum livro para devolver!");
        }

    }

}
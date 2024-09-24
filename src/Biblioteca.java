import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    Scanner captura = new Scanner(System.in);
    private static ArrayList<Livro> livros; //Lista de Livros
    private static ArrayList<Usuario> usuarios; //Lista de Usuários
    private static ArrayList<Livro> alugarLivro;


    public Biblioteca() {
        livros = new ArrayList<Livro>();
        usuarios = new ArrayList<Usuario>();
        alugarLivro = new ArrayList<Livro>();
    }

    public static ArrayList<Livro> getAlugarLivro() {
        return alugarLivro;
    }

    public static void setAlugarLivro(ArrayList<Livro> alugarLivro) {
        Biblioteca.alugarLivro = alugarLivro;
    }

    public static ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println(livro.getTitulo() + " Livro adicionado com sucesso!");
    }

    public void removerLivro(String livro) {
        livros.remove(livro);
        System.out.println(" Livro removido com sucesso!");
    }


    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario adicionado com sucesso!");
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
        System.out.println("Usuario removido com sucesso!");
    }

    public void adicionarCarrinho(Livro carrinho) {
        alugarLivro.add(carrinho);
        System.out.println("O livro será alugado por quantos dias?");
        int diaria = captura.nextInt();
        int itemCount = alugarLivro.size();
        double valor = 3.00;
        double valorFinal = diaria * valor * itemCount;
        System.out.println("Carrinho adicionado com sucesso! O valor total do seu carrinho atual é de R$"+ valorFinal);
    }

    public static void removerCarrinho() {
        alugarLivro.clear();
        System.out.println("Carrinho removido com sucesso!");
    }

    public static void devolverLivros() {
        alugarLivro.clear();
        System.out.println("Livros devolvidos com sucesso!");
    }


    public static Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public static Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

}

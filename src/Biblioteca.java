import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public static ArrayList<Livro> getAlugarLivro() { //Esse objeto chama a opção 6 - Mostrar livros alugados
        return alugarLivro;
    }

    public static void setAlugarLivro(ArrayList<Livro> alugarLivro) {
        Biblioteca.alugarLivro = alugarLivro;
    }

    public static ArrayList<Livro> getLivros() { //Esse objeto chama a opção 1 - Mostrar todos os livros
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

    public void adicionarLivro(Livro livro) { //Esse objeto adiciona os livros nos programa, opção 4
        livros.add(livro);
        System.out.println(livro.getTitulo() + " Livro adicionado com sucesso!");
    }

    public void removerLivro(String livro) {
        livros.remove(livro);
        System.out.println(" Livro removido com sucesso!");
    }


    public void adicionarUsuario(Usuario usuario) { //Adiciona o usuário no começo do programa
        usuarios.add(usuario);
        System.out.println("Usuario adicionado com sucesso!");
    }

    public void adicionarCarrinho(Livro carrinho) { //Adiciona os livros no carrinho. Faz parte da opção 2

        alugarLivro.add(carrinho); //Acrescenta o livro no carrinho
        System.out.println("O livro será alugado por quantos dias?");
        try {
            int diaria = captura.nextInt();
        int itemCount = alugarLivro.size();
        final double valor = 3.00;
        double valorFinal = diaria * valor * itemCount;
        System.out.println("Carrinho adicionado com sucesso! O valor total do seu carrinho atual é de R$"+ valorFinal);
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido, encerrando o programa");
        }
    }

    public static void removerCarrinho() { //Zera o carrinho
        alugarLivro.clear();
        System.out.println("Carrinho removido com sucesso!");
    }

    public static void devolverLivros() { //Zera o carrinho devolendo os livros
        alugarLivro.clear();
        System.out.println("Livros devolvidos com sucesso!");
    }


    public static Livro buscarLivro(String titulo) { //Busca o livro dentro de GetTitulo.
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

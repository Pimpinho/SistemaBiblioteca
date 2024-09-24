import java.util.Random; //Utilizado para gerar o ID do livro
import java.util.Scanner; // Importar os Scanners

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(); //Chamada da classe Biblioteca na Main
        Scanner entrada = new Scanner(System.in); //Todas as entradas do Scanner irão utilizar a variável "Entrada"



        System.out.println("Por gentileza, inserir o seu nome: "); //Captura o nome do usuário na inicialização do programa
        String nome2 = entrada.nextLine();
        biblioteca.adicionarUsuario(new Usuario(nome2)); //Adiciona o usuário no programa:

        //Lista de livros pré-carregados com o programa. ||| HAVERÁ EXIBIÇÃO NO PROMPT |||

        biblioteca.adicionarLivro(new Livro("0001", "O mundo de Sofia", "Jostein Gaarder", "Romance da Filofia", 568));
        biblioteca.adicionarLivro(new Livro("0002", "Código Limpo", "Robert C. Martin", "Educativo", 456));
        biblioteca.adicionarLivro(new Livro("0003", "Arte da guerra", "Suz Tzu", "Estratégia", 58));
        biblioteca.adicionarLivro(new Livro("0004", "O príncipe", "Maquiavel", "Infantil", 146));
        biblioteca.adicionarLivro(new Livro("0005", "SSH The secure Shell", "Daniel J. Barret", "Educativo", 614));

        Usuario usuario = Biblioteca.buscarUsuario(nome2); //Chamada da Classe usuário na Main.

        System.out.println("Usuário logado: " + nome2 ); //Confirmação de usuário cadastrado.
        try{
        int opcao; //Opção do Switch Case.
//      DO Switch Case para chamar as opções do programa.
        do {

                exibirOpcao();
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1: //Exibir Livros:
                        System.out.println(Biblioteca.getLivros());
                        break;
                    case 2: // Alugar Livros:

                        Livro livro;

                        if (usuario != null) { //Confere se o usuário foi informado"

                            System.out.println("Digite o titulo do livro");
                            entrada.nextLine();
                            String tituloLivro = entrada.nextLine();
                            livro = Biblioteca.buscarLivro(tituloLivro); //Busca pelo livro na base de getLivros Opção1

                            if (livro != null) { //Confere se o nome do livro foi inserido
                                usuario.alugarLivro(livro);
                                biblioteca.adicionarCarrinho(livro);
                            } else { //Se o livro não for localizado na base, vai cair nesse else que retornará a mensagem.
                                System.out.println("Livro não encontrado");
                            }
                        }
                        break;

                    case 3: // Devolver livro:

                        Biblioteca.devolverLivros(); //Devolve o livro
                        break;


                    case 4: // Adicionar livro:

                        entrada.nextLine();
                        System.out.println("Por favor, informar o título do livro: "); // Captura o título.
                        String tituloDoLivro = entrada.nextLine();

                        System.out.println("Por favor, informar o autor do livro: "); // Captura o autor.
                        String autorDoLivro = entrada.nextLine();

                        System.out.println("Por favor, informar a categoria do livro: "); // Captura a categoria.
                        String categoriaDoLivro = entrada.nextLine();


                        System.out.println("Por favor, informar a quantidade de páginas do livro: "); // Captura as páginas
                        int quantidadeDePaginasDoLivro = entrada.nextInt();
                        Random gerador = new Random();
                        int rdm = gerador.nextInt(1000);
                        String IDdoLivro = "00" + rdm;
                        // Cria o livro utilizando a mesma sintaxe que a primeira chamada do programa.
                        //Os dados são inseridos pelo usuário.
                        biblioteca.adicionarLivro(new Livro(IDdoLivro, tituloDoLivro, autorDoLivro, categoriaDoLivro, quantidadeDePaginasDoLivro));
                        break;

                    case 5: //Remover Livro:

                        Biblioteca.removerCarrinho(); //Remove o livro do carrinho
                        break;

                    case 6: // Meus livros alugados://

                        System.out.println(Biblioteca.getAlugarLivro()); // Chama os livros que foram alugados pelo usuário.
                        break;

                    case 7: // Sair:

                        System.out.println("Obrigado por usar nossos serviços");
                        break;

                    default:
                        System.out.println("Opção inválida!");

                }
            } while (opcao != 7) ;
        } catch(java.util.InputMismatchException e){
            System.out.println("Opção inválida, Saindo do programa.");
        entrada.close();
                }

}

    private static void exibirOpcao() { //Opções que são exibidas quando o programa roda com exatidão.
        System.out.println("===== BIBLIOTECA OXETECHLAB =====");
        System.out.println("[1] EXIBIR LIVROS :");
        System.out.println("[2] ALUGAR LIVRO(s):");
        System.out.println("[3] DEVOLVER LIVRO(s):");
        System.out.println("[4] ADICIONAR LIVRO(s)");
        System.out.println("[5] REMOVER LIVRO(s)");
        System.out.println("[6] MEUS LIVROS ALUGADOS");
        System.out.println("[7] SAIR");
        System.out.println("=================================");
    }


}

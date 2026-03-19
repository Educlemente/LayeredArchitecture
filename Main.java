import java.util.Scanner;

import JAVA.controller.LivroController;
import JAVA.controller.UsuarioController;
import JAVA.model.Livro;
import JAVA.service.EmprestimoService;
import JAVA.service.LivroService;
import JAVA.service.UsuarioService;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
int geradorIdLivro = 1;      
LivroService livroService = new LivroService();
UsuarioService usuarioService = new UsuarioService();
EmprestimoService emprestimoService = new EmprestimoService();


LivroController livroController = new LivroController(livroService);
UsuarioController usuarioController = new UsuarioController(usuarioService);
       
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n========= BIBLIOTECA ALTO NÍVEL =========");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Realizar Empréstimo (Regras Aluno B)");
            System.out.println("4. Devolver Livro (Regras Aluno B)");
            System.out.println("5. Listar Todos os Livros");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do usuário: ");
                        String nomeU = scanner.nextLine();
                        
                        System.out.println("Usuário " + nomeU + " cadastrado!");
                        break;
                    case 2:
                        
    System.out.print("Título do livro: ");
    String titulo = scanner.nextLine();
    System.out.print("Autor: ");
    String autor = scanner.nextLine();
    
   
    Livro novoLivro = new Livro(geradorIdLivro++, titulo, autor, 1, 1);
    livroController.cadastrar(novoLivro); 
    
    System.out.println("Livro cadastrado com sucesso!");
    break;
                        
                    case 3:
                        System.out.print("ID do Usuário: ");
                        int uId = scanner.nextInt();
                        System.out.print("ID do Livro: ");
                        int lId = scanner.nextInt();
                        
                        emprestimoService.realizarEmprestimo(uId, lId, 7);
                        break;
                    case 4:
                        System.out.print("ID do Empréstimo para devolver: ");
                        int empId = scanner.nextInt();
                       
                        emprestimoService.devolverLivro(empId);
                        break;
                    
                        case 5:
                            System.out.println("\n--- LISTA DE LIVROS ---");
                           
                            var livros = livroService.listarTodos();
    
                            if (livros == null || livros.isEmpty()) {
                                System.out.println("Nenhum livro cadastrado no sistema.");
                         } else {
                       
                         for (var livro : livros) {
                        System.out.println(livro.toString());
                             }
                        }
                     break;
                    case 6:
                        System.out.println("Encerrando sistema... Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Use apenas números.");
                scanner.nextLine(); // Limpa erro do scanner
            }
        }
        scanner.close();
    }
}
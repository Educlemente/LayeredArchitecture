package JAVA.service;
import java.util.List;
import java.time.LocalDate; // Importante para as datas

import JAVA.model.Emprestimo;
import JAVA.model.Livro; // Adicionei esse import
import JAVA.repository.EmprestimoRepository;
import JAVA.repository.LivroRepository;
import JAVA.repository.UsuarioRepository;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    public EmprestimoService() {
        this.emprestimoRepository = new EmprestimoRepository();
        this.usuarioRepository = new UsuarioRepository();
        this.livroRepository = new LivroRepository();
    }

    //  Realizar Empréstimo
    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {
        // 1. Buscar o livro no repositório
        Livro livro = livroRepository.buscarPorId(livroId);

        // REGRA OBRIGATÓRIA: Livro precisa existir
        if (livro == null) {
            System.out.println("Erro: Livro não encontrado!");
            return null;
        }

        // REGRA OBRIGATÓRIA: Não emprestar livro já emprestado
        if (livro.isEmprestado()) {
            System.out.println("Erro: O livro '" + livro.getNome() + "' já está emprestado!");
            return null;
        }

        // Se passou nas regras, cria o empréstimo
        Emprestimo novo = new Emprestimo(proximoId++, usuarioId, livroId, LocalDate.now(), LocalDate.now().plusDays(diasEmprestimo));
        
        // Marca o livro como emprestado
        livro.setEmprestado(true);
        
        // Salva
        emprestimoRepository.salvar(novo);
        System.out.println("Sucesso: Empréstimo realizado!");
        return novo;
    }

    //  Devolver Livro
    public void devolverLivro(int emprestimoId) {
        Emprestimo emp = emprestimoRepository.buscarPorId(emprestimoId);
        
        if (emp != null && emp.isAtivo()) {
            Livro livro = livroRepository.buscarPorId(emp.getLivroId());
            
            // REGRA OBRIGATÓRIA: Não devolver livro que não está emprestado (garantia)
            if (livro != null) {
                livro.setEmprestado(false);
                emp.setAtivo(false);
                emp.setDataDevoluçaoReal(LocalDate.now());
                System.out.println("Sucesso: Livro devolvido!");
            }
        } else {
            System.out.println("Erro: Empréstimo não encontrado ou já finalizado!");
        }
    }

    
    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.listarTodos();
    }
    
    public Emprestimo buscarPorId(int id) {
        return emprestimoRepository.buscarPorId(id);
    }
}
//ajuste6
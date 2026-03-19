package JAVA.controller;
import java.util.List;

import JAVA.model.Livro;
import JAVA.service.LivroService;

public class LivroController {
    private LivroService livroService;

    public LivroController() {
        this.livroService = new LivroService();
    }

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    // AGORA SIM: O Aluno A manda o livro para o Service
    public void cadastrar(Livro livro) {
        this.livroService.cadastrar(livro);
    }

    public Livro buscarPorId(int id) {
        return this.livroService.buscarPorId(id);
    }

    public List<Livro> buscarPorNome(String nome) {
        return this.livroService.buscarPorNome(nome);
    }

    public List<Livro> listarTodos() {
        return this.livroService.listarTodos();
    }

    public void alterar(Livro livro) {
        this.livroService.alterar(livro);
    }

    public void remover(int id) {
        this.livroService.remover(id);
    }
}
//ajuste7

package JAVA.service;
import java.util.List;

import JAVA.model.Livro;
import JAVA.repository.LivroRepository;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        this.livroRepository = new LivroRepository();
    }

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

   public void cadastrar(Livro livro) {
    livroRepository.salvar(livro);
   }
    public Livro buscarPorId(int id) {
        return null;
    }

    public List<Livro> buscarPorNome(String nome) {
        return null;
    }
    

   public List<Livro> listarTodos() {
    return livroRepository.listarTodos();
}
    

    public void alterar(Livro livro) {
    }

    public void remover(int id) {
    }
    
}

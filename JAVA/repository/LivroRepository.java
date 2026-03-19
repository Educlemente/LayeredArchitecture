package JAVA.repository;

import java.util.ArrayList;
import java.util.List;
import JAVA.model.Livro;

public class LivroRepository {

    
    private static List<Livro> livros = new ArrayList<>();

    
    public void salvar(Livro livro) {
        livros.add(livro);
    }

    
    public List<Livro> listarTodos() {
        return livros;
    }

    
    public Livro buscarPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null; // Retorna null se não achar
    }

    
    public List<Livro> buscarPorNome(String nome) {
        List<Livro> filtrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getNome().toLowerCase().contains(nome.toLowerCase())) {
                filtrados.add(livro);
            }
        }
        return filtrados;
    }

    
    public void atualizar(Livro livroAtualizado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getId() == livroAtualizado.getId()) {
                livros.set(i, livroAtualizado);
                break;
            }
        }
    }

    // DELETAR: Remove da lista pelo ID
    public void deletar(int id) {
        livros.removeIf(livro -> livro.getId() == id);
    }
}
//ajuste8

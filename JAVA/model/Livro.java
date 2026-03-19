package JAVA.model;
public class Livro {
    private int id;
    private String nome;
    private String autor;
    private int edicao;
    private int quantidade;

    public Livro() {
    }

    public Livro(int id, String nome, String autor, int edicao, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.edicao = edicao;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    private boolean emprestado = false;

public boolean isEmprestado() {
    return emprestado;
}

public void setEmprestado(boolean emprestado) {
    this.emprestado = emprestado;
}

   @Override
public String toString() {
    return String.format("ID: %d | Livro: %-20s | Autor: %-15s | Edição: %d | Qtd: %d", 
                         id, nome, autor, edicao, quantidade);
}
}
//ajuste2

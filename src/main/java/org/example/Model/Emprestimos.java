package org.example.Model;

import java.time.LocalDateTime;

public class Emprestimos {

    private int id;
    private int livro_id;
    private int usuario_id;
    private LocalDateTime data_emprestimo;
    private LocalDateTime data_devolucao;


    // METODO CONSTRUTOR COM ID E SEM ID
    public Emprestimos(int id, int livro_id, int usuario_id, LocalDateTime data_emprestimo, LocalDateTime data_devolucao) {
        this.id = id;
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    public Emprestimos(int livro_id, int usuario_id, LocalDateTime data_emprestimo, LocalDateTime data_devolucao) {
        this.livro_id = livro_id;
        this.usuario_id = usuario_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
    }

    // GETs e SETs
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(int livro_id) {
        this.livro_id = livro_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalDateTime getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(LocalDateTime data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public LocalDateTime getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(LocalDateTime data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
}

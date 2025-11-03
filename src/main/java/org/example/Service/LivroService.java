package org.example.Service;

import org.example.Infraestrutura.Conexao;
import org.example.Model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroService {


    // METODO PARA CADASTRAR LIVRO
    public void cadastrarLivro(Livros livros) throws SQLException {
        String query = "INSERT INTO livros (titulo, autor, ano, disponivel) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, livros.getTitulo());
            stmt.setString(2, livros.getAutor());
            stmt.setInt(3, livros.getAno());
            stmt.setBoolean(4, livros.isDisponivel());
            stmt.executeUpdate();
        }
    }

}

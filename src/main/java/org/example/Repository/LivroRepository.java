package org.example.Repository;

import org.example.Infraestrutura.Conexao;
import org.example.Model.Livros;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepository {


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


    // METODO PARA LISTAR TODOS OS LIVROS CADASTRADOS
    public List<Livros> listarLivros() throws SQLException {
        List<Livros> livros = new ArrayList<>();
        String query = "SELECT id, titulo, autor, ano, disponivel FROM livros";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                Livros livro = new Livros(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("ano"),
                        rs.getBoolean("disponivel")
                );
                livros.add(livro);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return livros;
    }




}

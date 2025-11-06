package org.example.Repository;

import org.example.Infraestrutura.Conexao;
import org.example.Model.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {


    //CADASTRAR USUARIOS
    public void cadastrarUsuario(Usuarios usuarios) throws SQLException {
        String query = "INSERT INTO Usuarios (nome, email) VALUES (?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuarios.getNome());
            stmt.setString(2, usuarios.getEmail());
            stmt.executeUpdate();
        }
    }


    // LISTA DE TODOS USUARIOS
    public List<Usuarios> listarUsuarios() throws SQLException {
        List<Usuarios> usuarios = new ArrayList<>();
        String query = "SELECT id, nome, email FROM Usuarios";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuarios usuario = new Usuarios(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email")
                );
                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}

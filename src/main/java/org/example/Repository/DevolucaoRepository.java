package org.example.Repository;

import org.example.Infraestrutura.Conexao;
import org.example.Model.Emprestimos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DevolucaoRepository {


    // METODO PARA REGISTRAR DEVOLUÇÃO DO LIVRO
    public void registrarDevolucaoDeLivro(Emprestimos emprestimos) throws SQLException {
        String query = "UPDATE emprestimos SET data_devolucao = ? WHERE id = ?";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(emprestimos.getData_devolucao()));
            stmt.setInt(2, emprestimos.getId());
            stmt.executeUpdate();
        }
    }
}

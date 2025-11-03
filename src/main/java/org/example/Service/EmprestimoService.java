package org.example.Service;

import org.example.Infraestrutura.Conexao;
import org.example.Model.Emprestimos;
import org.example.Model.Livros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmprestimoService {


    // METODO PARA REGISTRAR EMPRESTIMO DE LIVRO
    public void registrarEmprestimoDeLivro(Emprestimos emprestimos) throws SQLException {
        String query = "INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimos.getLivro_id());
            stmt.setInt(2, emprestimos.getUsuario_id());
            stmt.setTimestamp(3,java.sql.Timestamp.valueOf(emprestimos.getData_emprestimo()));
            stmt.executeUpdate();
        }
    }


    // METODO PARA REGISTRAR DEVOLUÇÃO DO LIVRO
    public void registrarDevolucaoDeLivro(Emprestimos emprestimos) throws SQLException {
        String query = "INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_devolucao) VALUES (?,?,?,?)";

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, emprestimos.getLivro_id());
            stmt.setInt(2, emprestimos.getUsuario_id());
            stmt.setTimestamp(3,java.sql.Timestamp.valueOf(emprestimos.getData_emprestimo()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(emprestimos.getData_devolucao()));
            stmt.executeUpdate();
        }
    }

}

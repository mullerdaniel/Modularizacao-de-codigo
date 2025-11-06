package org.example.Service;


import org.example.Model.Emprestimos;
import org.example.Repository.DevolucaoRepository;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DevolucaoService {
    static Scanner input = new Scanner(System.in);

    static EmprestimoService emprestimoService = new EmprestimoService();
    DevolucaoRepository devolucaoRepository = new DevolucaoRepository();


    // CADASTRAR DEVOLUÇÃO
    public void cadastrarDevolucao() throws SQLException {
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃>   Cadastrar Devolução   <┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        emprestimoService.listarEmprestimos();

        System.out.println("\nSelecione o ID do empréstimo a ser devolvido: ");
        int emprestimo_id = input.nextInt();

        Emprestimos emprestimo = new Emprestimos();
        emprestimo.setId(emprestimo_id);
        emprestimo.setData_devolucao(LocalDateTime.now());

        try {
            devolucaoRepository.registrarDevolucaoDeLivro(emprestimo);

            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Devolução registrada com sucesso! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        } catch (SQLException e) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Erro ao registrar devolução! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            throw new RuntimeException(e);
        }
    }

}

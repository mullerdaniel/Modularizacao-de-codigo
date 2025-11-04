package org.example.Service;

import org.example.Repository.LivroRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner input = new Scanner(System.in);

    static LivroRepository livroRepository = new LivroRepository();


    // CADASTRAR EMPRESTIMO
    public static void cadastrarEmprestimo() throws SQLException {
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃> Cadastrar Emprestimo <┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        livroRepository.listarLivros();
        System.out.println("\nSelecione a id de um livro.");
        int livro_id = input.nextInt();


    }

}

package org.example.Service;

import org.example.Model.Emprestimos;
import org.example.Model.Livros;
import org.example.Model.Usuarios;
import org.example.Repository.EmprestimoRepository;
import org.example.Repository.LivroRepository;
import org.example.Repository.UsuarioRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmprestimoService {
    static Scanner input = new Scanner(System.in);

    static LivroRepository livroRepository = new LivroRepository();
    static UsuarioRepository usuarioRepository = new UsuarioRepository();
    static EmprestimoRepository emprestimoRepository = new EmprestimoRepository();


    // CADASTRAR EMPRESTIMO
    public static void cadastrarEmprestimo() throws SQLException {
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃> Cadastrar Emprestimo <┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        // LISTAR LIVROS
        List<Livros> listarLivros = livroRepository.listarLivros();

        if (listarLivros.isEmpty()) {
            System.out.println("\nNão existem livros cadastrados.");
            return;
        }

        System.out.println("\nLivros Cadastrados: ");
        for (int i = 0; i < listarLivros.size(); i++) {
            Livros livros = listarLivros.get(i);
            System.out.println((i + 1) + " - Livro ID: " + livros.getId() + ", Titulo: " + livros.getTitulo() + ", Autor: " + livros.getAutor() + ", Ano: " + livros.getAno() + ", Disponivel: " + livros.isDisponivel());
        }

        System.out.println("\nSelecione a id de um livro: ");
        int livro_id = input.nextInt();



        // LISTAR USUARIOS
        List<Usuarios> listarUsuarios = usuarioRepository.listarUsuarios();

        if (listarUsuarios.isEmpty()) {
            System.out.println("\nNão existem usuarios cadastrados.");
            return;
        }

        System.out.println("\nUsuarios Cadastrados: ");
        for (int i = 0; i < listarUsuarios.size(); i++) {
            Usuarios usuarios = listarUsuarios.get(i);
            System.out.println((i + 1) + " - Usuario ID: " + usuarios.getId() + ", Nome: " + usuarios.getNome() + ", Email: " + usuarios.getEmail());
        }

        System.out.println("\nSelecione o id do usuario que irá pegar o livro: ");
        int usuario_id = input.nextInt();


        java.time.LocalDateTime data_empretismo = java.time.LocalDateTime.now();
        java.time.LocalDateTime data_devolucao = null;


        Emprestimos emprestimos = new Emprestimos(livro_id, usuario_id, data_empretismo, data_devolucao);

        try {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Empretimo Cadastrado com sucesso! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            emprestimoRepository.registrarEmprestimoDeLivro(emprestimos);

        } catch (SQLException e) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Erro ao Cadastrar Empretimo! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            throw new RuntimeException(e);
        }



    }

}

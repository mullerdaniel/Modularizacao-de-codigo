package org.example.Service;

import org.example.Model.Livros;
import org.example.Model.Usuarios;
import org.example.Repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UsuarioService {
    static Scanner input = new Scanner(System.in);
    UsuarioRepository usuarioRepository = new UsuarioRepository();


    // CADASTRAR USUARIO
    public void cadastrarUsuario() {
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃> Cadastrar Usuario <┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━┛\n");

        System.out.println("Escreva o nome do usuario: ");
        String nome = input.nextLine();

        System.out.println("Escreva o email do usuario: ");
        String email = input.nextLine();


        Usuarios usuarios = new Usuarios(nome, email);

        try {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Usuario Cadastrado com sucesso! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            usuarioRepository.cadastrarUsuario(usuarios);

        } catch (SQLException e) {
            System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Erro ao Cadastrar Usuario! <┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            throw new RuntimeException(e);
        }
    }

    // LISTAR TODOS OS USUARIOS
    public void listarUsuarios() throws SQLException {
        System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃> Lista dos Livros <┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛\n");
        List<Usuarios> usuarios = usuarioRepository.listarUsuarios();

        if(usuarios.isEmpty()) {
            System.out.println("Não há usuarios cadastrados!");

        }else {
            System.out.println("\n\nUsuarios:");
            for (Usuarios usuario : usuarios) {
                System.out.println("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", Email: " + usuario.getEmail());
            }
        }
    }
}

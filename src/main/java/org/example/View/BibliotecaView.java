package org.example.View;

import org.example.Service.EmprestimoService;
import org.example.Service.LivroService;
import org.example.Service.UsuarioService;

import java.sql.SQLException;
import java.util.Scanner;

public class BibliotecaView {
    static Scanner input = new Scanner(System.in);
    static BibliotecaView bibliotecaView = new BibliotecaView();

    LivroService livroService = new LivroService();
    EmprestimoService emprestimoService = new EmprestimoService();
    UsuarioService usuarioService = new UsuarioService();



    // METODO PARA MOSTRAR MENU
    public void mostrarMenu() {
            System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃> Sistema de Biblioteca <┃");
            System.out.println("┃-------------------------┃");
            System.out.println("┃1- Cadastrar Livro       ┃");
            System.out.println("┃2- Cadastrar Emprestimo  ┃");
            System.out.println("┃3- Devolução de Livro    ┃");
            System.out.println("┃4- Consultar             ┃");
            System.out.println("┃-------------------------┃");
            System.out.println("┃0- Sair                  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            bibliotecaView.capturarOpcao();
        }


        // METODO PARA CAPTURAR OPCAO
        public void capturarOpcao() {
            boolean sair = false;

            while(sair != true) {

                int opcao = input.nextInt();

                switch (opcao) {

                    case 1: {
                        livroService.cadastrarLivro();
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 2: {
                        usuarioService.cadastrarUsuario();
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 3: {
                        try {
                            emprestimoService.cadastrarEmprestimo();
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 4: {
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 5: {
                        bibliotecaView.menuConsulta();
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 0: {
                        System.out.println("\n\n┏━━━━━━━━━┓");
                        System.out.println("┃Saindo...┃");
                        System.out.println("┗━━━━━━━━━┛");
                        sair = false;
                        break;
                    }

                    default: {
                        System.out.println("\nOpção incorreta!");
                        bibliotecaView.mostrarMenu();
                        break;
                    }
                }
            }

        }


        // MENU DE CONSULTAS
        public void menuConsulta() {
                System.out.println("\n\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃>           Consultas           <┃");
                System.out.println("┃---------------------------------┃");
                System.out.println("┃1- Consultar Todos os Livros     ┃");
                System.out.println("┃2- Consultar Todos os Emprestimo ┃");
                System.out.println("┃---------------------------------┃");
                System.out.println("┃0- Voltar                        ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
                int opcao = input.nextInt();

                switch (opcao) {

                    case 1: {
                        bibliotecaView.menuConsulta();
                        break;
                    }

                    case 2: {
                        bibliotecaView.menuConsulta();
                        break;
                    }

                    case 0: {
                        System.out.println("\n\n┏━━━━━━━━━━━┓");
                        System.out.println("┃Voltando...┃");
                        System.out.println("┗━━━━━━━━━━━┛");
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    default: {
                        System.out.println("\nOpção incorreta!");
                        bibliotecaView.menuConsulta();
                        break;
                    }
                }



    }
    }


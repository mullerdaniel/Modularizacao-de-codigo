package org.example.View;

import java.util.Scanner;

public class BibliotecaView {
    static Scanner input = new Scanner(System.in);
    static BibliotecaView bibliotecaView = new BibliotecaView();



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
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 2: {
                        bibliotecaView.mostrarMenu();

                        break;
                    }

                    case 3: {
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 4: {
                        bibliotecaView.mostrarMenu();
                        break;
                    }

                    case 0: {
                        System.out.println("\n\n┏━━━━━━━━━┓");
                        System.out.println("┃Saindo...┃");
                        System.out.println("┗━━━━━━━━━┛");
                        sair = true;
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
    }


package org.example.View;

import java.util.Scanner;

public class BibliotecaView {
    static Scanner input = new Scanner(System.in);


    // METODO PARA MOSTRAR MENU
    public void mostrarMenu() {

        boolean sair = false;

        while (sair != true) {
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

            int opcao = input.nextInt();

            switch (opcao) {

                case 1: {
                    break;
                }

                case 2: {
                    break;
                }

                case 3: {
                    break;
                }

                case 4: {
                    break;
                }

                case 0: {
                    System.out.println("\n\n┏━━━━━━━━━┓");
                    System.out.println("┃Saindo...┃");
                    System.out.println("┗━━━━━━━━━┛");
                    sair = true;
                }
            }

        }
    }
}

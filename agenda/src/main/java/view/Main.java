package view;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendamentoView agendamentoView = new AgendamentoView();
        AtendenteView atendenteView = new AtendenteView();
        BarbeiroView barbeiroView = new BarbeiroView();
        ServicoAgendamentoView servicoAgendamentoView = new ServicoAgendamentoView();
        ServicoView servicoView = new ServicoView();
        ClienteView clienteView = new ClienteView();

        while (true) {
            System.out.println("Menu Principal");
            System.out.println("1. Gerenciar Agendamentos");
            System.out.println("2. Gerenciar Atendentes");
            System.out.println("3. Gerenciar Barbeiros");
            System.out.println("4. Gerenciar Serviços de Agendamento");
            System.out.println("5. Gerenciar Serviços");
            System.out.println("6. Gerenciar Clientes");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    agendamentoView.showMenu();
                    break;
                case 2:
                    atendenteView.showMenu();
                    break;
                case 3:
                    barbeiroView.showMenu();
                    break;
                case 4:
                    servicoAgendamentoView.showMenu();
                    break;
                case 5:
                    servicoView.showMenu();
                    break;
                case 6:
                    clienteView.showMenu();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

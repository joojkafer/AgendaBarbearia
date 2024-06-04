package view;

import java.util.List;
import java.util.Scanner;

import controller.AtendenteController;
import model.entity.Atendente;

public class AtendenteView {
    private AtendenteController atendenteController = new AtendenteController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Atendentes");
            System.out.println("2. Adicionar Atendente");
            System.out.println("3. Atualizar Atendente");
            System.out.println("4. Deletar Atendente");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Atendente> atendentes = atendenteController.getAllAtendentes();
                    for (Atendente atendente : atendentes) {
                        System.out.println("ID: " + atendente.getIdAtendente() +
                                           ", Nome: " + atendente.getNome() +
                                           ", CPF: " + atendente.getCpf() +
                                           ", Login: " + atendente.getUserLogin());
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do atendente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do atendente:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o login do atendente:");
                    String userLogin = scanner.nextLine();
                    System.out.println("Digite a senha do atendente:");
                    String userPassword = scanner.nextLine();
                    Atendente novoAtendente = new Atendente();
                    novoAtendente.setNome(nome);
                    novoAtendente.setCpf(cpf);
                    novoAtendente.setUserLogin(userLogin);
                    novoAtendente.setUserPassword(userPassword);
                    atendenteController.createAtendente(novoAtendente);
                    break;
                case 3:
                    System.out.println("Digite o ID do atendente para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do atendente:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo CPF do atendente:");
                    String novoCpf = scanner.nextLine();
                    System.out.println("Digite o novo login do atendente:");
                    String novoUserLogin = scanner.nextLine();
                    System.out.println("Digite a nova senha do atendente:");
                    String novoUserPassword = scanner.nextLine();
                    Atendente atendenteDetails = new Atendente();
                    atendenteDetails.setNome(novoNome);
                    atendenteDetails.setCpf(novoCpf);
                    atendenteDetails.setUserLogin(novoUserLogin);
                    atendenteDetails.setUserPassword(novoUserPassword);
                    atendenteController.updateAtendente(id, atendenteDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do atendente para deletar:");
                    int deleteId = scanner.nextInt();
                    atendenteController.deleteAtendente(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

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
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    List<Atendente> atendentes = atendenteController.getAllAtendentes();
                    for (Atendente atendente : atendentes) {
                        System.out.println(atendente);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do atendente:");
                    String name = scanner.nextLine();
                    Atendente novoAtendente = new Atendente();
                    novoAtendente.setName(name);
                    atendenteController.createAtendente(novoAtendente);
                    break;
                case 3:
                    System.out.println("Digite o ID do atendente para atualizar:");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Digite o novo nome do atendente:");
                    String newName = scanner.nextLine();
                    Atendente atendenteDetails = new Atendente();
                    atendenteDetails.setName(newName);
                    atendenteController.updateAtendente(id, atendenteDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do atendente para deletar:");
                    Long deleteId = scanner.nextLong();
                    atendenteController.deleteAtendente(deleteId);
                    break;
                case 0:
                    return;
            }
        }
    }
}

package view;

import java.util.List;
import java.util.Scanner;

import controller.BarbeiroController;
import model.entity.Barbeiro;

public class BarbeiroView {
    private BarbeiroController barbeiroController = new BarbeiroController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Barbeiros");
            System.out.println("2. Adicionar Barbeiro");
            System.out.println("3. Atualizar Barbeiro");
            System.out.println("4. Deletar Barbeiro");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    List<Barbeiro> barbeiros = barbeiroController.getAllBarbeiros();
                    for (Barbeiro barbeiro : barbeiros) {
                        System.out.println(barbeiro);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do barbeiro:");
                    String name = scanner.nextLine();
                    Barbeiro novoBarbeiro = new Barbeiro();
                    novoBarbeiro.setName(name);
                    barbeiroController.createBarbeiro(novoBarbeiro);
                    break;
                case 3:
                    System.out.println("Digite o ID do barbeiro para atualizar:");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Digite o novo nome do barbeiro:");
                    String newName = scanner.nextLine();
                    Barbeiro barbeiroDetails = new Barbeiro();
                    barbeiroDetails.setName(newName);
                    barbeiroController.updateBarbeiro(id, barbeiroDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do barbeiro para deletar:");
                    Long deleteId = scanner.nextLong();
                    barbeiroController.deleteBarbeiro(deleteId);
                    break;
                case 0:
                    return;
            }
        }
    }
}

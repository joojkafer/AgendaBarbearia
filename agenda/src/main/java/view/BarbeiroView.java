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
                        System.out.println("ID: " + barbeiro.getIdBarbeiro() +
                                           ", Nome: " + barbeiro.getNome() +
                                           ", Status: " + (barbeiro.isStatusBarbeiro() ? "Ativo" : "Inativo"));
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do barbeiro:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o status do barbeiro (true para ativo, false para inativo):");
                    boolean status = scanner.nextBoolean();
                    scanner.nextLine();
                    Barbeiro novoBarbeiro = new Barbeiro();
                    novoBarbeiro.setNome(nome);
                    novoBarbeiro.setStatusBarbeiro(status);
                    barbeiroController.createBarbeiro(novoBarbeiro);
                    break;
                case 3:
                    System.out.println("Digite o ID do barbeiro para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do barbeiro:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo status do barbeiro (true para ativo, false para inativo):");
                    boolean novoStatus = scanner.nextBoolean();
                    scanner.nextLine();
                    Barbeiro barbeiroDetails = new Barbeiro();
                    barbeiroDetails.setNome(novoNome);
                    barbeiroDetails.setStatusBarbeiro(novoStatus);
                    barbeiroController.updateBarbeiro(id, barbeiroDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do barbeiro para deletar:");
                    int deleteId = scanner.nextInt();
                    barbeiroController.deleteBarbeiro(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

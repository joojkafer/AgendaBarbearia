package view;

import java.util.List;
import java.util.Scanner;

import controller.ServicoController;
import model.entity.Servicos;

public class ServicoView {
    private ServicoController servicoController = new ServicoController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Servicos");
            System.out.println("2. Adicionar Servico");
            System.out.println("3. Atualizar Servico");
            System.out.println("4. Deletar Servico");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    List<Servicos> servicos = servicoController.getAllServicos();
                    for (Servicos servico : servicos) {
                        System.out.println(servico);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do servico:");
                    String name = scanner.nextLine();
                    Servicos novoServico = new Servicos();
                    novoServico.setName(name);
                    servicoController.createServico(novoServico);
                    break;
                case 3:
                    System.out.println("Digite o ID do servico para atualizar:");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Digite o novo nome do servico:");
                    String newName = scanner.nextLine();
                    Servicos servicoDetails = new Servicos();
                    servicoDetails.setName(newName);
                    servicoController.updateServico(id, servicoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do servico para deletar:");
                    Long deleteId = scanner.nextLong();
                    servicoController.deleteServico(deleteId);
                    break;
                case 0:
                    return;
            }
        }
    }
}

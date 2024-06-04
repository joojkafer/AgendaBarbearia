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
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Servicos> servicos = servicoController.getAllServicos();
                    for (Servicos servico : servicos) {
                        System.out.println("ID: " + servico.getIdServico() +
                                           ", Serviço: " + servico.getServico() +
                                           ", Descrição: " + servico.getDescServico() +
                                           ", Valor: " + servico.getValorServico());
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do serviço:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a descrição do serviço:");
                    String descricao = scanner.nextLine();
                    System.out.println("Digite o valor do serviço:");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();
                    Servicos novoServico = new Servicos();
                    novoServico.setServico(nome);
                    novoServico.setDescServico(descricao);
                    novoServico.setValorServico(valor);
                    servicoController.createServico(novoServico);
                    break;
                case 3:
                    System.out.println("Digite o ID do serviço para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do serviço:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite a nova descrição do serviço:");
                    String novaDescricao = scanner.nextLine();
                    System.out.println("Digite o novo valor do serviço:");
                    double novoValor = scanner.nextDouble();
                    scanner.nextLine();
                    Servicos servicoDetails = new Servicos();
                    servicoDetails.setServico(novoNome);
                    servicoDetails.setDescServico(novaDescricao);
                    servicoDetails.setValorServico(novoValor);
                    servicoController.updateServico(id, servicoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do serviço para deletar:");
                    int deleteId = scanner.nextInt();
                    servicoController.deleteServico(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

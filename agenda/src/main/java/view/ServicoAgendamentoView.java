package view;

import java.util.List;
import java.util.Scanner;

import controller.ServicoAgendamentoController;
import model.entity.ServicoAgendamento;

public class ServicoAgendamentoView {
    private ServicoAgendamentoController servicoAgendamentoController = new ServicoAgendamentoController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Servicos de Agendamento");
            System.out.println("2. Adicionar Servico de Agendamento");
            System.out.println("3. Atualizar Servico de Agendamento");
            System.out.println("4. Deletar Servico de Agendamento");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    List<ServicoAgendamento> servicoAgendamentos = servicoAgendamentoController.getAllServicoAgendamentos();
                    for (ServicoAgendamento servicoAgendamento : servicoAgendamentos) {
                        System.out.println(servicoAgendamento);
                    }
                    break;
                case 2:
                    System.out.println("Digite o serviço do agendamento:");
                    String service = scanner.nextLine();
                    ServicoAgendamento novoServicoAgendamento = new ServicoAgendamento();
                    novoServicoAgendamento.setService(service);
                    servicoAgendamentoController.createServicoAgendamento(novoServicoAgendamento);
                    break;
                case 3:
                    System.out.println("Digite o ID do servico de agendamento para atualizar:");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Digite o novo serviço do agendamento:");
                    String newService = scanner.nextLine();
                    ServicoAgendamento servicoAgendamentoDetails = new ServicoAgendamento();
                    servicoAgendamentoDetails.setService(newService);
                    servicoAgendamentoController.updateServicoAgendamento(id, servicoAgendamentoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do servico de agendamento para deletar:");
                    Long deleteId = scanner.nextLong();
                    servicoAgendamentoController.deleteServicoAgendamento(deleteId);
                    break;
                case 0:
                    return;
            }
        }
    }
}

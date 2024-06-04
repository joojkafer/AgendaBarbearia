package view;

import java.util.List;
import java.util.Scanner;

import controller.AgendamentoController;
import controller.ServicoAgendamentoController;
import controller.ServicoController;
import model.entity.Agendamento;
import model.entity.ServicoAgendamento;
import model.entity.Servicos;

public class ServicoAgendamentoView {
    private ServicoAgendamentoController servicoAgendamentoController = new ServicoAgendamentoController();
    private AgendamentoController agendamentoController = new AgendamentoController();
    private ServicoController servicoController = new ServicoController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Serviços Agendados");
            System.out.println("2. Adicionar Serviço ao Agendamento");
            System.out.println("3. Atualizar Serviço do Agendamento");
            System.out.println("4. Deletar Serviço do Agendamento");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<ServicoAgendamento> servicoAgendamentos = servicoAgendamentoController.getAllServicoAgendamentos();
                    for (ServicoAgendamento servicoAgendamento : servicoAgendamentos) {
                        System.out.println("ID: " + servicoAgendamento.getIdServicosAgendamento() +
                                           ", Agendamento ID: " + servicoAgendamento.getAgendamento().getIdAgendamento() +
                                           ", Serviço: " + servicoAgendamento.getServico().getServico());
                    }
                    break;
                case 2:
                    System.out.println("Digite o ID do agendamento:");
                    int agendamentoId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ID do serviço:");
                    int servicoId = scanner.nextInt();
                    scanner.nextLine();

                    Agendamento agendamento = agendamentoController.findById(agendamentoId);
                    Servicos servico = servicoController.findById(servicoId);

                    ServicoAgendamento novoServicoAgendamento = new ServicoAgendamento();
                    novoServicoAgendamento.setAgendamento(agendamento);
                    novoServicoAgendamento.setServico(servico);
                    servicoAgendamentoController.createServicoAgendamento(novoServicoAgendamento);
                    break;
                case 3:
                    System.out.println("Digite o ID do serviço agendado para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o novo ID do agendamento:");
                    int newAgendamentoId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o novo ID do serviço:");
                    int newServicoId = scanner.nextInt();
                    scanner.nextLine();

                    Agendamento newAgendamento = agendamentoController.findById(newAgendamentoId);
                    Servicos newServico = servicoController.findById(newServicoId);

                    ServicoAgendamento servicoAgendamentoDetails = new ServicoAgendamento();
                    servicoAgendamentoDetails.setAgendamento(newAgendamento);
                    servicoAgendamentoDetails.setServico(newServico);
                    servicoAgendamentoController.updateServicoAgendamento(id, servicoAgendamentoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do serviço agendado para deletar:");
                    int deleteId = scanner.nextInt();
                    servicoAgendamentoController.deleteServicoAgendamento(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

package view;

import java.util.List;
import java.util.Scanner;

import controller.AgendamentoController;
import model.entity.Agendamento;

public class AgendamentoView {
    private AgendamentoController agendamentoController = new AgendamentoController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Agendamentos");
            System.out.println("2. Adicionar Agendamento");
            System.out.println("3. Atualizar Agendamento");
            System.out.println("4. Deletar Agendamento");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    List<Agendamento> agendamentos = agendamentoController.getAllAgendamentos();
                    for (Agendamento agendamento : agendamentos) {
                        System.out.println(agendamento);
                    }
                    break;
                case 2:
                    System.out.println("Digite a data do agendamento:");
                    String date = scanner.nextLine();
                    Agendamento novoAgendamento = new Agendamento();
                    novoAgendamento.setDate(date);
                    agendamentoController.createAgendamento(novoAgendamento);
                    break;
                case 3:
                    System.out.println("Digite o ID do agendamento para atualizar:");
                    Long id = scanner.nextLong();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Digite a nova data do agendamento:");
                    String newDate = scanner.nextLine();
                    Agendamento agendamentoDetails = new Agendamento();
                    agendamentoDetails.setDate(newDate);
                    agendamentoController.updateAgendamento(id, agendamentoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do agendamento para deletar:");
                    Long deleteId = scanner.nextLong();
                    agendamentoController.deleteAgendamento(deleteId);
                    break;
                case 0:
                    return;
            }
        }
    }
}

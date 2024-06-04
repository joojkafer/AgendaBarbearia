package view;

import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import controller.AgendamentoController;
import controller.BarbeiroController;
import controller.ClienteController;
import model.entity.Agendamento;
import model.entity.Barbeiro;
import model.entity.Cliente;
import model.entity.HorarioEnum;

public class AgendamentoView {
    private AgendamentoController agendamentoController = new AgendamentoController();
    private BarbeiroController barbeiroController = new BarbeiroController();
    private ClienteController clienteController = new ClienteController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Agendamentos");
            System.out.println("2. Adicionar Agendamento");
            System.out.println("3. Atualizar Agendamento");
            System.out.println("4. Deletar Agendamento");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Agendamento> agendamentos = agendamentoController.getAllAgendamentos();
                    for (Agendamento agendamento : agendamentos) {
                        System.out.println("ID: " + agendamento.getIdAgendamento() +
                                           ", Data: " + agendamento.getDataAgendamento() +
                                           ", Horário: " + agendamento.getHorario().getHorario() +
                                           ", Barbeiro: " + agendamento.getBarbeiro().getNome() +
                                           ", Cliente: " + agendamento.getCliente().getNome());
                    }
                    break;
                case 2:
                    System.out.println("Digite a data do agendamento (YYYY-MM-DD):");
                    String data = scanner.nextLine();

                    System.out.println("Selecione o horário:");
                    for (HorarioEnum horarioEnum : HorarioEnum.values()) {
                        System.out.println(horarioEnum.ordinal() + 1 + ". " + horarioEnum.getHorario());
                    }
                    int horarioChoice = scanner.nextInt();
                    scanner.nextLine(); 
                    HorarioEnum horario = HorarioEnum.values()[horarioChoice - 1];

                    System.out.println("Digite o ID do barbeiro:");
                    int barbeiroId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ID do cliente:");
                    int clienteId = scanner.nextInt();
                    scanner.nextLine();

                    Barbeiro barbeiro = barbeiroController.findById(barbeiroId);
                    Cliente cliente = clienteController.findById(clienteId);

                    Agendamento novoAgendamento = new Agendamento();
                    novoAgendamento.setDataAgendamento(Date.valueOf(data));
                    novoAgendamento.setHorario(horario);
                    novoAgendamento.setBarbeiro(barbeiro);
                    novoAgendamento.setCliente(cliente);
                    agendamentoController.createAgendamento(novoAgendamento);
                    break;
                case 3:
                    System.out.println("Digite o ID do agendamento para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite a nova data do agendamento (YYYY-MM-DD):");
                    String newData = scanner.nextLine();

                    System.out.println("Selecione o novo horário:");
                    for (HorarioEnum horarioEnum : HorarioEnum.values()) {
                        System.out.println(horarioEnum.ordinal() + 1 + ". " + horarioEnum.getHorario());
                    }
                    int newHorarioChoice = scanner.nextInt();
                    scanner.nextLine();
                    HorarioEnum newHorario = HorarioEnum.values()[newHorarioChoice - 1];

                    System.out.println("Digite o novo ID do barbeiro:");
                    int newBarbeiroId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o novo ID do cliente:");
                    int newClienteId = scanner.nextInt();
                    scanner.nextLine(); 

                    Barbeiro newBarbeiro = barbeiroController.findById(newBarbeiroId);
                    Cliente newCliente = clienteController.findById(newClienteId);

                    Agendamento agendamentoDetails = new Agendamento();
                    agendamentoDetails.setDataAgendamento(Date.valueOf(newData));
                    agendamentoDetails.setHorario(newHorario);
                    agendamentoDetails.setBarbeiro(newBarbeiro);
                    agendamentoDetails.setCliente(newCliente);
                    agendamentoController.updateAgendamento(id, agendamentoDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do agendamento para deletar:");
                    int deleteId = scanner.nextInt();
                    agendamentoController.deleteAgendamento(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}

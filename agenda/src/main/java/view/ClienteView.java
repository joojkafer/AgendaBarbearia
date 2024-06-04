package view;

import java.util.List;
import java.util.Scanner;

import controller.ClienteController;
import model.entity.Cliente;

public class ClienteView {
    private ClienteController clienteController = new ClienteController();

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Listar Clientes");
            System.out.println("2. Adicionar Cliente");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Deletar Cliente");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    List<Cliente> clientes = clienteController.getAllClientes();
                    for (Cliente cliente : clientes) {
                        System.out.println("ID: " + cliente.getIdCliente() +
                                           ", Nome: " + cliente.getNome() +
                                           ", CPF: " + cliente.getCpf() +
                                           ", Telefone: " + cliente.getTelefone());
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o telefone do cliente:");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = new Cliente();
                    novoCliente.setNome(nome);
                    novoCliente.setCpf(cpf);
                    novoCliente.setTelefone(telefone);
                    clienteController.createCliente(novoCliente);
                    break;
                case 3:
                    System.out.println("Digite o ID do cliente para atualizar:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o novo nome do cliente:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo CPF do cliente:");
                    String novoCpf = scanner.nextLine();
                    System.out.println("Digite o novo telefone do cliente:");
                    String novoTelefone = scanner.nextLine();
                    Cliente clienteDetails = new Cliente();
                    clienteDetails.setNome(novoNome);
                    clienteDetails.setCpf(novoCpf);
                    clienteDetails.setTelefone(novoTelefone);
                    clienteController.updateCliente(id, clienteDetails);
                    break;
                case 4:
                    System.out.println("Digite o ID do cliente para deletar:");
                    int deleteId = scanner.nextInt();
                    clienteController.deleteCliente(deleteId);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

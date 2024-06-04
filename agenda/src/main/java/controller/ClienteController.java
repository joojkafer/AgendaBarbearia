package controller;

import java.util.List;

import model.entity.Cliente;
import model.repository.ClienteRepository;

public class ClienteController {
    private ClienteRepository clienteRepository = new ClienteRepository();

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(int id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        cliente.setNome(clienteDetails.getNome());
        cliente.setCpf(clienteDetails.getCpf());
        cliente.setTelefone(clienteDetails.getTelefone());
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
        clienteRepository.delete(cliente);
    }

    public Cliente findById(int id) {
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente not found"));
    }
}

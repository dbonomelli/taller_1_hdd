package cl.usm.hdd.taller1.services;

import cl.usm.hdd.taller1.entities.Cliente;
import cl.usm.hdd.taller1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceimpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public Cliente ingresarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        return cliente;
    }

    @Override
    public List<Cliente> mostrarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public List<Cliente> mostrarClientesFiltro(String estado) {
        return clienteRepository.findByEstado(estado);
    }
}

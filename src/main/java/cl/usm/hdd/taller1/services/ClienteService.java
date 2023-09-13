package cl.usm.hdd.taller1.services;

import cl.usm.hdd.taller1.entities.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente ingresarCliente(Cliente cliente);
    List<Cliente> mostrarClientes();
    List<Cliente> mostrarClientesFiltro(String estado);
}

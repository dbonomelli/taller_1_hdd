package cl.usm.hdd.taller1.controllers;

import cl.usm.hdd.taller1.entities.Cliente;
import cl.usm.hdd.taller1.services.ClienteService;
import cl.usm.hdd.taller1.utils.ClienteUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/ingresarCliente")
    public ResponseEntity<Cliente> ingresarCliente(@RequestBody Cliente cliente){
        if(!ClienteUtils.validarRut(cliente.getRut())){
            return ResponseEntity.badRequest().build();
        }
        try {
            Cliente nuevoCliente = clienteService.ingresarCliente(cliente);
            return ResponseEntity.ok(nuevoCliente);
        } catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/mostrarClientes")
    public ResponseEntity<List<Cliente>> mostrarClientes(){
        try{
            return ResponseEntity.ok(clienteService.mostrarClientes());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/mostrarClientes/{estado}")
    public ResponseEntity<List<Cliente>> mostrarClientesFiltro(@PathVariable String estado){
        try{
            return ResponseEntity.ok(clienteService.mostrarClientesFiltro(estado));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}

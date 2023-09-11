package cl.usm.hdd.taller1.controllers;

import cl.usm.hdd.taller1.entities.Cliente;
import cl.usm.hdd.taller1.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static jdk.nashorn.internal.objects.Global.print;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/ingresarCliente")
    public ResponseEntity<Cliente> ingresarCliente(@RequestBody Cliente cliente){
        try {
            Cliente nuevoCliente = clienteService.ingresarCliente(cliente);
            return ResponseEntity.ok(nuevoCliente);
        } catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}

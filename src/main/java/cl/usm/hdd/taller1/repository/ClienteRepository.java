package cl.usm.hdd.taller1.repository;

import cl.usm.hdd.taller1.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    @Query("{estado:'?0'}")
    List<Cliente> findByEstado(String estado);
    public long count();
}

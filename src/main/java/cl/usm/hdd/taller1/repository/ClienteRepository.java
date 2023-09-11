package cl.usm.hdd.taller1.repository;

import cl.usm.hdd.taller1.entities.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    public long count();
}

package cl.usm.hdd.taller1.entities;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document("cliente")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    private String apellidos;
    private String rut;
    private int numSerie;
    private String estado;

}

package fabricio.buffa.challengePinApp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Table(value = "client")
public record ClientModel(
        @Id String id,
        @Column(value = "name") String name,
        @Column(value = "lastName") String lastName,
        @Column(value = "age") Integer age,
        @Column(value = "birthDate") Instant birthDate
) {
}

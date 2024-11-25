package fabricio.buffa.challengePinApp.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(value = "client")
@AllArgsConstructor
@Getter
public class ClientModel implements Persistable<String> {
    @Id String id;
    @Column(value = "name") String name;
    @Column(value = "lastName") String lastName;
    @Column(value = "age") Integer age;
    @Column(value = "birthDate") LocalDate birthDate;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}

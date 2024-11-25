package fabricio.buffa.challengePinApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record ClientResponse(
        String id,
        @JsonProperty("nombre")
        String name,
        @JsonProperty("apellido")
        String lastName,
        @JsonProperty("edad")
        Integer age,
        @JsonProperty("fechaNacimiento")
        LocalDate birthDate,
        @JsonProperty("fechaMuerteProbable")
        LocalDate probablyDeathDate
) {
}

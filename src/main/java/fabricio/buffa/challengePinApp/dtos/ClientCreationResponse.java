package fabricio.buffa.challengePinApp.dtos;

import java.time.LocalDate;

public record ClientCreationResponse(
        String name,
        String lastName,
        Integer age,
        LocalDate birthdate

) {

}

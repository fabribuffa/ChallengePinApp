package fabricio.buffa.challengePinApp.dtos;

import java.time.LocalDate;

public record ClientCreationPetitionDto(
        String name,
        String lastName,
        Integer age,
        LocalDate birthDate
) {

}

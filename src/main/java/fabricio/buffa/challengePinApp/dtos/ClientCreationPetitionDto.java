package fabricio.buffa.challengePinApp.dtos;

import java.time.Instant;

public record ClientCreationPetitionDto(
        String name,
        String lastName,
        Integer age,
        Instant birthDate
) {

}

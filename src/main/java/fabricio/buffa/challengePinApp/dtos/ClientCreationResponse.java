package fabricio.buffa.challengePinApp.dtos;

import java.time.Instant;

public record ClientCreationResponse(
        String name,
        String lastName,
        Integer age,
        Instant birthdate

) {

}

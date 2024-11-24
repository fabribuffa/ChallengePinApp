package fabricio.buffa.challengePinApp.dtos;

import java.time.Instant;

public record ClientResponse(
        String id,
        String name,
        String lastName,
        Integer age,
        Instant birthDate,
        Instant probablyDeathDate
) {
}

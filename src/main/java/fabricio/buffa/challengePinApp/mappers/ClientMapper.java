package fabricio.buffa.challengePinApp.mappers;

import fabricio.buffa.challengePinApp.dtos.ClientCreationPetitionDto;
import fabricio.buffa.challengePinApp.dtos.ClientCreationResponse;
import fabricio.buffa.challengePinApp.dtos.GetKpiClientsResponse;
import fabricio.buffa.challengePinApp.models.ClientModel;
import fabricio.buffa.challengePinApp.models.KpiModel;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class ClientMapper {

    public static ClientModel toModel(ClientCreationPetitionDto clientCreationPetitionDto) {
        return new ClientModel(
                UUID.randomUUID().toString(),
                clientCreationPetitionDto.name(),
                clientCreationPetitionDto.lastName(),
                clientCreationPetitionDto.age(),
                clientCreationPetitionDto.birthDate());
    }

    public static ClientCreationResponse toResponse(ClientModel model) {
        return new ClientCreationResponse(
                model.name(),
                model.lastName(),
                model.age(),
                model.birthDate());

    }

    public static GetKpiClientsResponse toKpiResponse(KpiModel model) {
        return new GetKpiClientsResponse(
                model.avg(),model.std());

    }
}

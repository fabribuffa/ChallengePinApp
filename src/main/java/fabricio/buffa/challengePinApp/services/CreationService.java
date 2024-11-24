package fabricio.buffa.challengePinApp.services;

import fabricio.buffa.challengePinApp.dtos.ClientCreationPetitionDto;
import fabricio.buffa.challengePinApp.mappers.ClientMapper;
import fabricio.buffa.challengePinApp.models.ClientModel;
import fabricio.buffa.challengePinApp.repository.ClientRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreationService {

    private final ClientRespository clientRespository;


    public Mono<ClientModel> create(ClientCreationPetitionDto clientCreationPetitionDto) {
        return clientRespository.save(ClientMapper.toModel(clientCreationPetitionDto));
    }
}

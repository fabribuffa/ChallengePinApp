package fabricio.buffa.challengePinApp.services;

import fabricio.buffa.challengePinApp.dtos.ClientResponse;
import fabricio.buffa.challengePinApp.models.ClientModel;
import fabricio.buffa.challengePinApp.models.KpiModel;
import fabricio.buffa.challengePinApp.repository.ClientRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;


@Component
@RequiredArgsConstructor
@Slf4j
public class RetrieveService {

    private final ClientRespository clientRespository;

    public Mono<KpiModel> getKpiClients() {
        return clientRespository.getKpis()
                .doOnSuccess(model -> log.info("The kpi of clients are retrieved successfully"))
                .doOnError(error -> log.error("The kpi of clients are retrieved with error", error));
    }

    public Flux<ClientResponse> getAll() {
        return clientRespository.findAll()
                .map(this::calculateDeathDate)
                .doOnError(error -> log.error("The all clients retrieve has failed", error)); //todo: check
    }


    private ClientResponse calculateDeathDate(ClientModel clientModel) {
        Integer hopeOfLive = 75;
        LocalDate probablyDeath = LocalDate.now().plusYears(hopeOfLive - clientModel.getAge());
        return new ClientResponse(
                clientModel.getId(),
                clientModel.getName(),
                clientModel.getLastName(),
                clientModel.getAge(),
                clientModel.getBirthDate(),
                probablyDeath);
    }


}

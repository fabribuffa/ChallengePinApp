package fabricio.buffa.challengePinApp.controllers;

import fabricio.buffa.challengePinApp.dtos.ClientCreationPetitionDto;
import fabricio.buffa.challengePinApp.dtos.ClientCreationResponse;
import fabricio.buffa.challengePinApp.dtos.ClientResponse;
import fabricio.buffa.challengePinApp.dtos.GetKpiClientsResponse;
import fabricio.buffa.challengePinApp.mappers.ClientMapper;
import fabricio.buffa.challengePinApp.services.CreationService;
import fabricio.buffa.challengePinApp.services.RetrieveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientsController {

    private final CreationService creationService;
    private final RetrieveService retrieveService;

    @PostMapping("/creacliente")
    public Mono<ResponseEntity<ClientCreationResponse>> postClient(@RequestBody ClientCreationPetitionDto request) {
        return creationService.create(request)
                .map(ClientMapper::toResponse)
                .map(response -> ResponseEntity.status(CREATED).body(response));

    }

    @GetMapping("/kpiclientes")
    public Mono<ResponseEntity<GetKpiClientsResponse>> getKpiClients() {
        return retrieveService.getKpiClients()
                .map(ClientMapper::toKpiResponse)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/listclientes") //todo: por buenas practicas se deberia implementar paginacion
    public Mono<ResponseEntity<List<ClientResponse>>> getClients() {
        return retrieveService.getAll()
                .collectList()
                .map(ResponseEntity::ok);
    }

}

package fabricio.buffa.challengePinApp.controllers;

import fabricio.buffa.challengePinApp.dtos.ClientCreationPetitionDto;
import fabricio.buffa.challengePinApp.dtos.ClientCreationResponse;
import fabricio.buffa.challengePinApp.dtos.ClientResponse;
import fabricio.buffa.challengePinApp.dtos.GetKpiClientsResponse;
import fabricio.buffa.challengePinApp.mappers.ClientMapper;
import fabricio.buffa.challengePinApp.services.CreationService;
import fabricio.buffa.challengePinApp.services.RetrieveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ClientsController {

    private final CreationService creationService;
    private final RetrieveService retrieveService;

    @Operation(summary = "creacion de un cliente")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "cliente creado exitosamente",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ClientResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            )
    })
    @PostMapping("/creacliente")
    public Mono<ResponseEntity<ClientCreationResponse>> postClient(@RequestBody ClientCreationPetitionDto request) {
        return creationService.create(request)
                .map(ClientMapper::toResponse)
                .map(response -> ResponseEntity.status(CREATED).body(response));

    }

    @Operation(summary = "Obtener kpis de los clientes")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Los kpis se obtuvieron correctamente",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GetKpiClientsResponse.class)
                    )
            )
    })
    @GetMapping("/kpiclientes")
    public Mono<ResponseEntity<GetKpiClientsResponse>> getKpiClients() {
        return retrieveService.getKpiClients()
                .map(ClientMapper::toKpiResponse)
                .map(ResponseEntity::ok);
    }

    @Operation(summary = "Obtener todos los clientes")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Se obtuvieron todos los clientes correctamente",
                    content = @Content(
                            mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = GetKpiClientsResponse.class)
                    )
            )
    })
    @GetMapping("/listclientes") //todo: por buenas practicas se deberia implementar paginacion
    public Mono<ResponseEntity<List<ClientResponse>>> getClients() {
        return retrieveService.getAll()
                .collectList()
                .map(ResponseEntity::ok);
    }

}

package fabricio.buffa.challengePinApp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GetKpiClientsResponse(
        @JsonProperty("edadPromedio")
        Double ageAverage,
        @JsonProperty("desaviacionEstandar")
        Double ageStd
) {

}

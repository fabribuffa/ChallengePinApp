package fabricio.buffa.challengePinApp.repository;

import fabricio.buffa.challengePinApp.models.ClientModel;
import fabricio.buffa.challengePinApp.models.KpiModel;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ClientRespository extends ReactiveCrudRepository<ClientModel, String> {

    @Query("SELECT AVG(age), STDDEV(age)" +
            "FROM client")
    Mono<KpiModel> getKpis();
}

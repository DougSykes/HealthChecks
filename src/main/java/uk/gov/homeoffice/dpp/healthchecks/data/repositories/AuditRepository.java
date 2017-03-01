package uk.gov.homeoffice.dpp.healthchecks.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.gov.homeoffice.dpp.healthchecks.data.entities.Audit;

/**
 * Created by C.Barnes on 01/03/2017.
 */
public interface AuditRepository extends JpaRepository<Audit, Long> {
}

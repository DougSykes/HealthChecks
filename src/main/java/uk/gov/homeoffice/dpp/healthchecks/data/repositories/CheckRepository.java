package uk.gov.homeoffice.dpp.healthchecks.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.homeoffice.dpp.healthchecks.data.entities.Check;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Repository
@Transactional
public interface CheckRepository extends JpaRepository<Check, Long> {



}

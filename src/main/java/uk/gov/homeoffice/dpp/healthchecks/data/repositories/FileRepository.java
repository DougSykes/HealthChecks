package uk.gov.homeoffice.dpp.healthchecks.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.homeoffice.dpp.healthchecks.data.entities.File;

import java.util.List;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Repository
@Transactional
public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findByFilepath(String filepath);

}

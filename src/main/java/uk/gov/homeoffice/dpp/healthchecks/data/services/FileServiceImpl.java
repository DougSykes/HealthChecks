package uk.gov.homeoffice.dpp.healthchecks.data.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.gov.homeoffice.dpp.healthchecks.data.entities.File;
import uk.gov.homeoffice.dpp.healthchecks.data.repositories.FileRepository;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by C.Barnes on 01/03/2017.
 */
@Service("FileService")
public class FileServiceImpl implements FileService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private FileRepository fileRepository;

    @Override
    public List<File> getAllFiles() {
        return fileRepository.findAll();
    }

    @Transactional
    @Override
    public List<File> getAllFilesWithAudits(){

        EntityGraph graph = this.em.getEntityGraph("graph.File.audits");

        CriteriaQuery<File> qu = em.getCriteriaBuilder().createQuery(File.class);
        Root<File> r =  qu.from(File.class);

        TypedQuery<File> tp = em.createQuery(qu);
        tp.setHint("javax.persistence.fetchgraph", graph);

        List<File> files = tp.getResultList();

        return files;
    }

}

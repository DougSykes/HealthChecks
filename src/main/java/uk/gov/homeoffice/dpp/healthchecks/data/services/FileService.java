package uk.gov.homeoffice.dpp.healthchecks.data.services;

import uk.gov.homeoffice.dpp.healthchecks.data.entities.File;

import java.util.List;

/**
 * Created by C.Barnes on 01/03/2017.
 */
public interface FileService {

    List<File> getAllFiles();

    List<File> getAllFilesWithAudits();

}

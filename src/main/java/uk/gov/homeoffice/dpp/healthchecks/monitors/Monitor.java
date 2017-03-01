package uk.gov.homeoffice.dpp.healthchecks.monitors;

import java.nio.file.WatchService;

/**
 * Created by koskinasm on 13/02/2017.
 */
public interface Monitor {

    public void monitor(WatchService watchService);
}

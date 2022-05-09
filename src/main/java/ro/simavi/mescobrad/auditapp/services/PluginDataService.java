package ro.simavi.mescobrad.auditapp.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.List;

public interface PluginDataService {
    List<PluginData> pluginData();
    List<PluginData> findAll();
    List<PluginData> findAllByName(String name);
    List<PluginData> findAllByVersion(String version);
    List<PluginData> findAllByNameAndVersion(String name, String version);
    List<PluginData> findAllByNameAndVersionAndType(String name, String version, String type);
    PluginData findFirstById(String id);

    List<PluginData> findLikeName(String name);
    List<PluginData> findLikeNameVersionType(String name,
            String version,
            String type
    );

}

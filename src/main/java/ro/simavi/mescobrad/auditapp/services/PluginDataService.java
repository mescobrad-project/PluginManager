package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.List;

public interface PluginDataService {
    List<PluginData> pluginData();
    List<PluginData> findAll();
    List<PluginData> findAllByName(String name);
    List<PluginData> findAllByNameAndVersion(String name, String version);
    List<PluginData> findAllByVersion(String version);
    PluginData findFirstById(String id);
}

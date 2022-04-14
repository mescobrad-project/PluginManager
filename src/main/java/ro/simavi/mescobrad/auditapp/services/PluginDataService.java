package ro.simavi.mescobrad.auditapp.services;

import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.List;

public interface PluginDataService {
    List<PluginData> pluginData();
}

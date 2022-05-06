package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.List;

@Transactional
public interface PluginDataRepository extends JpaRepository<PluginData, Long>
{
    List<PluginData> findAllByName(String name);
    List<PluginData> findAllByNameAndVersion(String name, String version);
    List<PluginData> findAllByVersion(String version);
    PluginData findFirstById(String id);
}


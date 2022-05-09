package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ro.simavi.mescobrad.auditapp.entities.PluginData;

import java.util.List;

@Transactional
public interface PluginDataRepository extends JpaRepository<PluginData, Long>
{
    List<PluginData> findAllByName(String name);
    List<PluginData> findAllByVersion(String version);
    List<PluginData> findAllByVersionAndName(String version, String name);
    List<PluginData> findAllByVersionAndNameAndType(String version, String name, String type);

    @Query("SELECT pd FROM PluginData pd WHERE lower(pd.name) LIKE  lower(concat('%', :nameToFind, '%'))")
    List<PluginData> findLikeName(@Param("nameToFind") String name);

    @Query("SELECT pd FROM PluginData pd WHERE (lower(pd.name) LIKE  lower(concat('%', :nameToFind, '%'))) AND (lower(pd.version) LIKE  lower(concat('%', :versionToFind, '%'))) AND (lower(pd.type) LIKE  lower(concat('%', :typeToFind, '%')))")
    List<PluginData> findLikeNameVersionType(@Param("nameToFind") String name,
            @Param("versionToFind") String version,
            @Param("typeToFind") String type
    );

    PluginData findFirstById(String id);
}


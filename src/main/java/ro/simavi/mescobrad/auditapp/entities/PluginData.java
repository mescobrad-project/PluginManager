package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PluginData
{
    private Long id;

    private String pluginType;

    private Date registeredDate;

    private String owner;

    private String version;

    private String pluginDescription;

    private String pluginPrerequisites;
}

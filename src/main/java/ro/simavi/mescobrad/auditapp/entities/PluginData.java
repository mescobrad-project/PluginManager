package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table(name = "plugin_data")
@Entity(name = "PluginData")
public class PluginData
{
    @Id
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="repo")
    private String repo;

    @Column(name="registered_date")
    private Date registeredDate;

    @Column(name="owner")
    private String owner;

    @Column(name="hash")
    private String hash;

    @Column(name="version")
    private String version;


    public PluginData(String id, String name){
        this.id = id;
        this.name = name;
    }

    public PluginData(String name){
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.name = name;
        this.repo = "https://github.com/mescobrad-project/edge-plugin-demo";
    }

    public PluginData(){
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
        this.name = "Noname";
        this.repo = "https://github.com/mescobrad-project/edge-plugin-demo";
    }
}

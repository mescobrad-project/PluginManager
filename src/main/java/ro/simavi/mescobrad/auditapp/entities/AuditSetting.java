package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Component
public class AuditSetting {
    private Long id;

    @Value("${mescobrad.audit.type}")
    private String auditType;

    @Value("${mescobrad.audit.severity}")
    private Long auditSeverity;

    @Value("${mescobrad.audit.applications}")
    private String auditAppList;

    @Value("${mescobrad.audit.events}")
    private String auditEventsList;

    private List<String> auditApplication;

    private List<String> auditEvents;

    public AuditSetting(){}

    public AuditSetting(Long l){
        id=1l;
        auditType ="all";
        auditSeverity=3L;
        if(auditAppList!=null && auditAppList.length()>0){
            String[] ls = auditAppList.split( ";" );
            for(int i=0; i<ls.length; i++){
                auditApplication.add(ls[i]);
            }
        }
        else{
            auditApplication.add( "MES-CoBraD" );
        }

        if(auditEventsList!=null && auditEventsList.length()>0){
            String[] ls = auditEventsList.split( ";" );
            for(int i=0; i<ls.length; i++){
                auditEvents.add(ls[i]);
            }
        }
        else{
            auditEvents.add( "all" );
        }
    }
}

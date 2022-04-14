package ro.simavi.mescobrad.auditapp.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ro.simavi.mescobrad.auditapp.entities.AuditData;
import ro.simavi.mescobrad.auditapp.entities.AuditSetting;
import ro.simavi.mescobrad.auditapp.services.AuditDataService;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Component
@Scope("session")
public class SettingsController {
    @Autowired
    AuditSetting auditSetting;

    @Autowired
    AuditDataService auditDataService;

    private Date fromDate;

    private Date toDate;

    private String currentOwner;

    private String currentApp;

    private String currentModule;


    public AuditSetting getAuditSetting()
    {
        return auditSetting;
    }

    public void setAuditSetting( AuditSetting auditSetting )
    {
        this.auditSetting = auditSetting;
    }

    public List<AuditData> getAuditDataList()
    {
        return auditDataList;
    }

    public void setAuditDataList( List<AuditData> auditDataList )
    {
        this.auditDataList = auditDataList;
    }

    List<AuditData> auditDataList;

    List<AuditData> selectedAuditDataList;

    @PostConstruct
    private void postConstruct(){
        auditDataList = auditDataService.auditData();
    }

    public boolean isRendered(String place){
        return true;
    }

    public void save(){
        return;
    }

    public void update(){
        return;
    }

    public void filterContext() {
        return;}

    public void resetFilter() {
        return;}


}

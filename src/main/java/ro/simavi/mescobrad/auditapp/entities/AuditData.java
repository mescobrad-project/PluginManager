package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuditData
{
    private Long id;

    private String auditType;

    private Long auditSeverity;

    private Date registeredDate;

    private String owner;

    private String ip;

    private String auditContent;
}

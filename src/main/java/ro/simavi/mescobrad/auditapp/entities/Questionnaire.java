package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "mcb_questionaire", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity(name = "Questionnaire")
public class Questionnaire {

    @Id
    @Column(name = "questionaire_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionnaireId;

    @Column(name = "questionaire_name")
    private String questionnaireName;

    @Column(name = "respondent_type")
    private String respondentType;

    @Column(name = "questionaire_type")
    private String questionnaireType;

    @Column(name = "creation_date_time")
    private String creationDateTime;


}

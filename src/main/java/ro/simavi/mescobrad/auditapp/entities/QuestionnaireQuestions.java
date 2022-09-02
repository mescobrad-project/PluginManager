package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "mcb_questionaire_questions", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity
public class QuestionnaireQuestions {

    @Id
    @Column(name = "qq_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long qqId;

    @Column(name = "qq_questionaire_id")
    private Integer qqQuestionnaireId;

    @Column(name = "qq_question_id")
    private Integer qqQuestionId;
}

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
@Table(name = "mcb_questions_variables", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity(name = "QuestionsVariables")
public class QuestionsVariables {
    @Id
    @Column(name = "mcb_q_v_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idQV;

    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "variable_id")
    private Long variableId;
}

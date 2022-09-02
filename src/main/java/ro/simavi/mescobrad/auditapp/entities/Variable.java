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
@Table(name = "mcb_variables", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity(name = "Variable")
public class Variable {
    @Id
    @Column(name = "variable_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variableId;

    @Column(name = "variable_name")
    private String variableName;

    @Column(name = "concept_ref")
    private Long conceptRef;

    @Column(name = "category_ref")
    private Long categoryRef;

    @Column(name = "level_of_measurement")
    private String levelOfMeasurement;

    @Column(name = "sql_data_type")
    private String sqlDataType;

    @Column(name = "measurement_unit")
    private String measurementUnit;

    @Column(name = "directly_measured")
    private Integer directlyMeasured;

    @Column(name = "formula")
    private String formula;

    @Column(name = "no_of_possible_answers")
    private Integer noOfPossibleAnswers;

    @Column(name = "description")
    private String description;

}

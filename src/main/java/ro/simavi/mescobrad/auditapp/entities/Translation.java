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
@Table(name = "mcb_translations", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity(name = "Translation")
public class Translation {
    @Id
    @Column(name = "translation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long translationId;

    @Column(name = "question_text")
    private String translationQuestionText;

    @Column(name = "ref_lang")
    private String refLang;
}

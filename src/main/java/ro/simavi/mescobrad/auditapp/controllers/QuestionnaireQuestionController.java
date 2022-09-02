package ro.simavi.mescobrad.auditapp.controllers;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.simavi.mescobrad.auditapp.entities.Questionnaire;
import ro.simavi.mescobrad.auditapp.entities.QuestionnaireQuestions;
import ro.simavi.mescobrad.auditapp.entities.Questions;
import ro.simavi.mescobrad.auditapp.repositories.QuestionnaireQuestionsRepository;
import ro.simavi.mescobrad.auditapp.repositories.QuestionnaireRepository;
import ro.simavi.mescobrad.auditapp.repositories.QuestionsRepository;
import ro.simavi.mescobrad.auditapp.services.QQService;
import ro.simavi.mescobrad.auditapp.services.QuestionnaireService;
import ro.simavi.mescobrad.auditapp.services.QuestionsService;

import javax.annotation.PostConstruct;
import java.util.List;

@Getter
@Setter
@Component
public class QuestionnaireQuestionController {
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private QuestionsService questionsService;

    @Autowired
    private QuestionnaireQuestionsRepository questionnaireQuestionsRepository;

    @Autowired
    private QQService qqService;

    List<Questionnaire> questionnaireList;
    List<Questions> questionsList;
    List<QuestionnaireQuestions> qqList;

    Questionnaire questionnaireSelected ;
    Questions questionSelected;
    QuestionnaireQuestions selectedQQ;

    @PostConstruct
    public void init(){
        questionnaireList = questionnaireRepository.findAll();
        questionsList = questionsRepository.findAll();
        qqList = questionnaireQuestionsRepository.findAll();
    }

    public void saveQuestionnaire() {
        questionnaireService.saveQuestionnaireToDB( this.questionnaireSelected );
        questionnaireList = questionnaireRepository.findAll();

        PrimeFaces.current().executeScript("PF('manageQuestionnaire').hide()");
        PrimeFaces.current().ajax().update("questionnaireForm:questionnaireData");
    }

    public void deleteQuestionnaire() {
        this.questionnaireRepository.deleteById( this.questionnaireSelected.getQuestionnaireId() );
        this.questionnaireList.remove( this.questionnaireSelected );
        this.questionnaireSelected = null;

        PrimeFaces.current().ajax().update( "questionnaireForm:questionnaireData");
    }

    public void openNewQuestionnaire() {
        this.questionnaireSelected = new Questionnaire();
    }

    public void saveQuestion() {
        questionsService.saveQuestionToDB( questionSelected );
        questionsList = questionsRepository.findAll();

        PrimeFaces.current().executeScript("PF('manageQuestion').hide()");
        PrimeFaces.current().ajax().update("questionForm:questionsData");
    }

    public void deleteQuestion() {
        this.questionsRepository.deleteById( questionSelected.getQuestionId() );
        this.questionsList.remove( this.questionSelected );
        this.questionSelected = null;

        PrimeFaces.current().ajax().update( "questionForm:questionsData");
    }

    public void openNewQuestion() {
        this.questionSelected = new Questions();
    }

    public void saveQQ() {
        qqService.saveQQToDB( selectedQQ );
        qqList = questionnaireQuestionsRepository.findAll();

        PrimeFaces.current().executeScript("PF('manageQQ').hide()");
        PrimeFaces.current().ajax().update("formQQ:dataQQ");
    }

    public void deleteQQ() {
        this.questionnaireQuestionsRepository.deleteById( selectedQQ.getQqId() );
        this.qqList.remove( this.selectedQQ );
        this.selectedQQ = null;

        PrimeFaces.current().ajax().update( "formQQ:dataQQ");
    }

    public void openNewQQ() {
        this.selectedQQ = new QuestionnaireQuestions();
    }


}

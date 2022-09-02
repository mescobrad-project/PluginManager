package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.Questionnaire;
import ro.simavi.mescobrad.auditapp.repositories.QuestionnaireRepository;
import ro.simavi.mescobrad.auditapp.services.QuestionnaireService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;


@Service
public class QuestionnaireServiceImpl implements QuestionnaireService
{
    @Autowired
    private QuestionnaireRepository questionnaireRepository;

    @Override
    public Questionnaire saveQuestionnaireToDB(Questionnaire questionnaireSelected) {

        if( Objects.nonNull( questionnaireSelected.getQuestionnaireId() ) ){
            Optional<Questionnaire> questionnaireEntityOptional = this.questionnaireRepository.findById( questionnaireSelected.getQuestionnaireId());
            if (questionnaireEntityOptional.isPresent()) {
                questionnaireEntityOptional.get().setRespondentType( questionnaireSelected.getRespondentType() );
                questionnaireEntityOptional.get().setQuestionnaireType( questionnaireSelected.getQuestionnaireType() );
                questionnaireEntityOptional.get().setCreationDateTime( questionnaireSelected.getCreationDateTime() );
                questionnaireEntityOptional.get().setQuestionnaireName( questionnaireSelected.getQuestionnaireName() );
                this.questionnaireRepository.save(questionnaireEntityOptional.get());
                return questionnaireEntityOptional.get();
            }
        }

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setRespondentType( questionnaireSelected.getRespondentType() );
        questionnaire.setQuestionnaireType( questionnaireSelected.getQuestionnaireType() );
        questionnaire.setCreationDateTime( LocalDateTime.now().format( DateTimeFormatter.ISO_LOCAL_DATE_TIME ) );
        questionnaire.setQuestionnaireName( questionnaireSelected.getQuestionnaireName() );
        this.questionnaireRepository.save( questionnaire );
        return questionnaire;
    }
}

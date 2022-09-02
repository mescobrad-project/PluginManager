package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.Questionnaire;
import ro.simavi.mescobrad.auditapp.entities.QuestionnaireQuestions;
import ro.simavi.mescobrad.auditapp.repositories.QuestionnaireQuestionsRepository;
import ro.simavi.mescobrad.auditapp.services.QQService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

@Service
public class QQServiceImpl implements QQService {
    @Autowired
    QuestionnaireQuestionsRepository questionnaireQuestionsRepository;


    @Override
    public QuestionnaireQuestions saveQQToDB( QuestionnaireQuestions selectedQQ ) {
        if( Objects.nonNull( selectedQQ.getQqId() ) ){
            Optional<QuestionnaireQuestions> questionnaireQuestionsOptional = this.questionnaireQuestionsRepository.findById( selectedQQ.getQqId());
            if (questionnaireQuestionsOptional.isPresent()) {
                questionnaireQuestionsOptional.get().setQqQuestionnaireId( selectedQQ.getQqQuestionnaireId() );
                questionnaireQuestionsOptional.get().setQqQuestionId( selectedQQ.getQqQuestionId() );
                this.questionnaireQuestionsRepository.save(questionnaireQuestionsOptional.get());
                return questionnaireQuestionsOptional.get();
            }
        }

        QuestionnaireQuestions qq = new QuestionnaireQuestions();
        qq.setQqQuestionnaireId( selectedQQ.getQqQuestionnaireId() );
        qq.setQqQuestionId( selectedQQ.getQqQuestionId() );
        this.questionnaireQuestionsRepository.save( qq );
        return qq;
    }
}

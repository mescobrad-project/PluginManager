package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.Questions;
import ro.simavi.mescobrad.auditapp.repositories.QuestionsRepository;
import ro.simavi.mescobrad.auditapp.services.QuestionsService;

import java.util.Objects;
import java.util.Optional;

@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    QuestionsRepository questionsRepository;


    @Override
    public Questions saveQuestionToDB( Questions questionSelected ) {
        if( Objects.nonNull( questionSelected.getQuestionId()) ){
            Optional<Questions> questionEntityOptional = this.questionsRepository.findById( questionSelected.getQuestionId());
            if (questionEntityOptional.isPresent()) {
                questionEntityOptional.get().setQuestionText( questionSelected.getQuestionText() );
                this.questionsRepository.save(questionEntityOptional.get());
                return questionEntityOptional.get();
            }
        }

        Questions question = new Questions();
        question.setQuestionText( questionSelected.getQuestionText() );
        this.questionsRepository.save( question );
        return question;
    }
}

package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.simavi.mescobrad.auditapp.entities.QuestionnaireQuestions;

public interface QuestionnaireQuestionsRepository extends JpaRepository<QuestionnaireQuestions, Long> {
}

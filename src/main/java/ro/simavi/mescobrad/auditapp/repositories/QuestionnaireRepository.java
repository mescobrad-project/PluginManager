package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.simavi.mescobrad.auditapp.entities.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
}

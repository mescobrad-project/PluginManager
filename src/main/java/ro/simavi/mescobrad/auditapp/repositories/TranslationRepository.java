package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.simavi.mescobrad.auditapp.entities.Translation;

public interface TranslationRepository extends JpaRepository<Translation, Long>
{
}

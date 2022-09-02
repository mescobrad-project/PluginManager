package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.simavi.mescobrad.auditapp.entities.Variable;

public interface VariableRepository extends JpaRepository<Variable, Long>
{
}

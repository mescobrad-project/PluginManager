package ro.simavi.mescobrad.auditapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.simavi.mescobrad.auditapp.entities.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    List<Category> findAllByParentId (Integer parentId);
    Category findByParentId (Integer parentId);
}

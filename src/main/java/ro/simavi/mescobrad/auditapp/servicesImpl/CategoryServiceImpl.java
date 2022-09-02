package ro.simavi.mescobrad.auditapp.servicesImpl;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import org.springframework.stereotype.Service;
import ro.simavi.mescobrad.auditapp.entities.Category;
import ro.simavi.mescobrad.auditapp.repositories.CategoryRepository;
import ro.simavi.mescobrad.auditapp.services.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl( CategoryRepository categoryRepository )
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public TreeNode createTree(Category category, TreeNode rootNode) {
        TreeNode newNode = new DefaultTreeNode(category.getCategoryName(), category, rootNode);

        List<Category> childNodes1 = categoryRepository.findAllByParentId( category.getId() );

        for (Category tt : childNodes1) {
            TreeNode newNode2 = createTree(tt, newNode);
        }

        return newNode;
    }

}

package ro.simavi.mescobrad.auditapp.services;

import org.primefaces.model.TreeNode;
import ro.simavi.mescobrad.auditapp.entities.Category;

public interface CategoryService {
    TreeNode createTree( Category category, TreeNode rootNode);
}

package ro.simavi.mescobrad.auditapp.controllers;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.simavi.mescobrad.auditapp.entities.Category;
import ro.simavi.mescobrad.auditapp.repositories.CategoryRepository;
import ro.simavi.mescobrad.auditapp.services.CategoryService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Getter
@Setter
@Component
public class CategoriesController
{
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    private TreeNode root;
    private TreeNode selectedNode;
    private Category category;


    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Categories", null);
        TreeNode node = categoryService.createTree(categoryRepository.findByParentId( 0 ), root);
        this.category = new Category();
    }

    public void onRowEdit( RowEditEvent<TreeNode> event) {
        FacesMessage msg = new FacesMessage("Category Edited", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent<TreeNode> event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }

    public String saveCategory(){
        Category newCategory = new Category();
        newCategory.setCategoryName( category.getCategoryName() );
        TreeNode treeNode = new DefaultTreeNode(newCategory);
        treeNode.setParent( selectedNode );
        treeNode.getParent().getChildren().add( treeNode );

        category.setCategoryName( null );

        return "/pages/categories.xhtml?faces-redirect=true";
    }
}

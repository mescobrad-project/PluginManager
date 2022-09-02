package ro.simavi.mescobrad.auditapp.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "mcb_sts_categories", catalog = "mescobrad", schema = "mescobrad_dl")
@Entity(name = "Category")
public class Category
{
    @Id
    @Column(name = "mcb_sts_categ_id")
    private Integer id;

    @Column(name = "categ_name")
    private String categoryName;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "concept")
    private Integer concept;

    @Override
    public String toString()
    {
        return categoryName;
    }
}

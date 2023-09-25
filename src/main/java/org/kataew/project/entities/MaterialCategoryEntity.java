
package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "material_category", schema = "public", catalog = "db")
public class MaterialCategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_material_category")
    private Long idMaterialCategory;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdMaterialCategory() {
        return idMaterialCategory;
    }

    public void setIdMaterialCategory(Long idMaterialCategory) {
        this.idMaterialCategory = idMaterialCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialCategoryEntity that = (MaterialCategoryEntity) o;

        if (idMaterialCategory != null ? !idMaterialCategory.equals(that.idMaterialCategory) : that.idMaterialCategory != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaterialCategory != null ? idMaterialCategory.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}



package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "material", schema = "public", catalog = "db")
public class MaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_material")
    private Long idMaterial;
    @Basic
    @Column(name = "id_material_category")
    private Long idMaterialCategory;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "unit")
    private String unit;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialEntity that = (MaterialEntity) o;

        if (idMaterial != null ? !idMaterial.equals(that.idMaterial) : that.idMaterial != null) return false;
        if (idMaterialCategory != null ? !idMaterialCategory.equals(that.idMaterialCategory) : that.idMaterialCategory != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMaterial != null ? idMaterial.hashCode() : 0;
        result = 31 * result + (idMaterialCategory != null ? idMaterialCategory.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }
}


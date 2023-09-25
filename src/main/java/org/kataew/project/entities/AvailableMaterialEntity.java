package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "available_material", schema = "public", catalog = "db")
public class AvailableMaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_available_material")
    private Long idAvailableMaterial;
    @Basic
    @Column(name = "count")
    private Long count;
    @Basic
    @Column(name = "id_project")
    private Long idProject;
    @Basic
    @Column(name = "id_material")
    private Long idMaterial;

    public Long getIdAvailableMaterial() {
        return idAvailableMaterial;
    }

    public void setIdAvailableMaterial(Long idAvailableMaterial) {
        this.idAvailableMaterial = idAvailableMaterial;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AvailableMaterialEntity that = (AvailableMaterialEntity) o;

        if (idAvailableMaterial != null ? !idAvailableMaterial.equals(that.idAvailableMaterial) : that.idAvailableMaterial != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idMaterial != null ? !idMaterial.equals(that.idMaterial) : that.idMaterial != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAvailableMaterial != null ? idAvailableMaterial.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (idProject != null ? idProject.hashCode() : 0);
        result = 31 * result + (idMaterial != null ? idMaterial.hashCode() : 0);
        return result;
    }
}


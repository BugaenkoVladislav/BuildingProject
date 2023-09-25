package org.kataew.project.entities;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "project", schema = "public", catalog = "db")
public class ProjectEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_project")
    private Long idProject;
    @Basic
    @Column(name = "id_user")
    private Long idUser;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "photo")
    private byte[] photo;

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectEntity that = (ProjectEntity) o;

        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idUser != null ? !idUser.equals(that.idUser) : that.idUser != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (!Arrays.equals(photo, that.photo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProject != null ? idProject.hashCode() : 0;
        result = 31 * result + (idUser != null ? idUser.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }
}


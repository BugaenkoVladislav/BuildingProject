
package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "work_status", schema = "public", catalog = "db")
public class WorkStatusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_work_status")
    private Long idWorkStatus;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdWorkStatus() {
        return idWorkStatus;
    }

    public void setIdWorkStatus(Long idWorkStatus) {
        this.idWorkStatus = idWorkStatus;
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

        WorkStatusEntity that = (WorkStatusEntity) o;

        if (idWorkStatus != null ? !idWorkStatus.equals(that.idWorkStatus) : that.idWorkStatus != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWorkStatus != null ? idWorkStatus.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}



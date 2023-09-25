
package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "scope_of_work", schema = "public", catalog = "db")
public class ScopeOfWorkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_scope_of_work")
    private Long idScopeOfWork;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdScopeOfWork() {
        return idScopeOfWork;
    }

    public void setIdScopeOfWork(Long idScopeOfWork) {
        this.idScopeOfWork = idScopeOfWork;
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

        ScopeOfWorkEntity that = (ScopeOfWorkEntity) o;

        if (idScopeOfWork != null ? !idScopeOfWork.equals(that.idScopeOfWork) : that.idScopeOfWork != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idScopeOfWork != null ? idScopeOfWork.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

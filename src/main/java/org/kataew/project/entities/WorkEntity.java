
package org.kataew.project.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "work", schema = "public", catalog = "db")
public class WorkEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_work")
    private Long idWork;
    @Basic
    @Column(name = "expected_date_end")
    private Date expectedDateEnd;
    @Basic
    @Column(name = "expected_date_start")
    private Date expectedDateStart;
    @Basic
    @Column(name = "id_executor")
    private Long idExecutor;
    @Basic
    @Column(name = "id_project")
    private Long idProject;
    @Basic
    @Column(name = "id_scope_of_work")
    private Long idScopeOfWork;
    @Basic
    @Column(name = "id_work_status")
    private Long idWorkStatus;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "real_date_end")
    private Date realDateEnd;
    @Basic
    @Column(name = "real_date_start")
    private Date realDateStart;

    public Long getIdWork() {
        return idWork;
    }

    public void setIdWork(Long idWork) {
        this.idWork = idWork;
    }

    public Date getExpectedDateEnd() {
        return expectedDateEnd;
    }

    public void setExpectedDateEnd(Date expectedDateEnd) {
        this.expectedDateEnd = expectedDateEnd;
    }

    public Date getExpectedDateStart() {
        return expectedDateStart;
    }

    public void setExpectedDateStart(Date expectedDateStart) {
        this.expectedDateStart = expectedDateStart;
    }

    public Long getIdExecutor() {
        return idExecutor;
    }

    public void setIdExecutor(Long idExecutor) {
        this.idExecutor = idExecutor;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdScopeOfWork() {
        return idScopeOfWork;
    }

    public void setIdScopeOfWork(Long idScopeOfWork) {
        this.idScopeOfWork = idScopeOfWork;
    }

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

    public Date getRealDateEnd() {
        return realDateEnd;
    }

    public void setRealDateEnd(Date realDateEnd) {
        this.realDateEnd = realDateEnd;
    }

    public Date getRealDateStart() {
        return realDateStart;
    }

    public void setRealDateStart(Date realDateStart) {
        this.realDateStart = realDateStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkEntity that = (WorkEntity) o;

        if (idWork != null ? !idWork.equals(that.idWork) : that.idWork != null) return false;
        if (expectedDateEnd != null ? !expectedDateEnd.equals(that.expectedDateEnd) : that.expectedDateEnd != null)
            return false;
        if (expectedDateStart != null ? !expectedDateStart.equals(that.expectedDateStart) : that.expectedDateStart != null)
            return false;
        if (idExecutor != null ? !idExecutor.equals(that.idExecutor) : that.idExecutor != null) return false;
        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idScopeOfWork != null ? !idScopeOfWork.equals(that.idScopeOfWork) : that.idScopeOfWork != null)
            return false;
        if (idWorkStatus != null ? !idWorkStatus.equals(that.idWorkStatus) : that.idWorkStatus != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (realDateEnd != null ? !realDateEnd.equals(that.realDateEnd) : that.realDateEnd != null) return false;
        if (realDateStart != null ? !realDateStart.equals(that.realDateStart) : that.realDateStart != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idWork != null ? idWork.hashCode() : 0;
        result = 31 * result + (expectedDateEnd != null ? expectedDateEnd.hashCode() : 0);
        result = 31 * result + (expectedDateStart != null ? expectedDateStart.hashCode() : 0);
        result = 31 * result + (idExecutor != null ? idExecutor.hashCode() : 0);
        result = 31 * result + (idProject != null ? idProject.hashCode() : 0);
        result = 31 * result + (idScopeOfWork != null ? idScopeOfWork.hashCode() : 0);
        result = 31 * result + (idWorkStatus != null ? idWorkStatus.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (realDateEnd != null ? realDateEnd.hashCode() : 0);
        result = 31 * result + (realDateStart != null ? realDateStart.hashCode() : 0);
        return result;
    }
}

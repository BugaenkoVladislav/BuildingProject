package org.kataew.project.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "order_material", schema = "public", catalog = "db")
public class OrderMaterialEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_order_material")
    private Long idOrderMaterial;
    @Basic
    @Column(name = "count")
    private Long count;
    @Basic
    @Column(name = "expected_date_payment")
    private Date expectedDatePayment;
    @Basic
    @Column(name = "expected_date_supply")
    private Date expectedDateSupply;
    @Basic
    @Column(name = "id_material")
    private Long idMaterial;
    @Basic
    @Column(name = "id_order_material_status")
    private Long idOrderMaterialStatus;
    @Basic
    @Column(name = "id_project")
    private Long idProject;
    @Basic
    @Column(name = "id_provider")
    private Long idProvider;
    @Basic
    @Column(name = "real_date_payment")
    private Date realDatePayment;
    @Basic
    @Column(name = "real_date_supply")
    private Date realDateSupply;

    public Long getIdOrderMaterial() {
        return idOrderMaterial;
    }

    public void setIdOrderMaterial(Long idOrderMaterial) {
        this.idOrderMaterial = idOrderMaterial;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getExpectedDatePayment() {
        return expectedDatePayment;
    }

    public void setExpectedDatePayment(Date expectedDatePayment) {
        this.expectedDatePayment = expectedDatePayment;
    }

    public Date getExpectedDateSupply() {
        return expectedDateSupply;
    }

    public void setExpectedDateSupply(Date expectedDateSupply) {
        this.expectedDateSupply = expectedDateSupply;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Long getIdOrderMaterialStatus() {
        return idOrderMaterialStatus;
    }

    public void setIdOrderMaterialStatus(Long idOrderMaterialStatus) {
        this.idOrderMaterialStatus = idOrderMaterialStatus;
    }

    public Long getIdProject() {
        return idProject;
    }

    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public Date getRealDatePayment() {
        return realDatePayment;
    }

    public void setRealDatePayment(Date realDatePayment) {
        this.realDatePayment = realDatePayment;
    }

    public Date getRealDateSupply() {
        return realDateSupply;
    }

    public void setRealDateSupply(Date realDateSupply) {
        this.realDateSupply = realDateSupply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderMaterialEntity that = (OrderMaterialEntity) o;

        if (idOrderMaterial != null ? !idOrderMaterial.equals(that.idOrderMaterial) : that.idOrderMaterial != null)
            return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (expectedDatePayment != null ? !expectedDatePayment.equals(that.expectedDatePayment) : that.expectedDatePayment != null)
            return false;
        if (expectedDateSupply != null ? !expectedDateSupply.equals(that.expectedDateSupply) : that.expectedDateSupply != null)
            return false;
        if (idMaterial != null ? !idMaterial.equals(that.idMaterial) : that.idMaterial != null) return false;
        if (idOrderMaterialStatus != null ? !idOrderMaterialStatus.equals(that.idOrderMaterialStatus) : that.idOrderMaterialStatus != null)
            return false;
        if (idProject != null ? !idProject.equals(that.idProject) : that.idProject != null) return false;
        if (idProvider != null ? !idProvider.equals(that.idProvider) : that.idProvider != null) return false;
        if (realDatePayment != null ? !realDatePayment.equals(that.realDatePayment) : that.realDatePayment != null)
            return false;
        if (realDateSupply != null ? !realDateSupply.equals(that.realDateSupply) : that.realDateSupply != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrderMaterial != null ? idOrderMaterial.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (expectedDatePayment != null ? expectedDatePayment.hashCode() : 0);
        result = 31 * result + (expectedDateSupply != null ? expectedDateSupply.hashCode() : 0);
        result = 31 * result + (idMaterial != null ? idMaterial.hashCode() : 0);
        result = 31 * result + (idOrderMaterialStatus != null ? idOrderMaterialStatus.hashCode() : 0);
        result = 31 * result + (idProject != null ? idProject.hashCode() : 0);
        result = 31 * result + (idProvider != null ? idProvider.hashCode() : 0);
        result = 31 * result + (realDatePayment != null ? realDatePayment.hashCode() : 0);
        result = 31 * result + (realDateSupply != null ? realDateSupply.hashCode() : 0);
        return result;
    }
}



package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "fulfillment_conditions", schema = "public", catalog = "db")
public class FulfillmentConditionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_fulfillment_conditions")
    private Long idFulfillmentConditions;
    @Basic
    @Column(name = "id_order_material_condition")
    private Long idOrderMaterialCondition;
    @Basic
    @Column(name = "id_work")
    private Long idWork;
    @Basic
    @Column(name = "id_work_condition")
    private Long idWorkCondition;

    public Long getIdFulfillmentConditions() {
        return idFulfillmentConditions;
    }

    public void setIdFulfillmentConditions(Long idFulfillmentConditions) {
        this.idFulfillmentConditions = idFulfillmentConditions;
    }

    public Long getIdOrderMaterialCondition() {
        return idOrderMaterialCondition;
    }

    public void setIdOrderMaterialCondition(Long idOrderMaterialCondition) {
        this.idOrderMaterialCondition = idOrderMaterialCondition;
    }

    public Long getIdWork() {
        return idWork;
    }

    public void setIdWork(Long idWork) {
        this.idWork = idWork;
    }

    public Long getIdWorkCondition() {
        return idWorkCondition;
    }

    public void setIdWorkCondition(Long idWorkStatus) {
        this.idWorkCondition = idWorkCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FulfillmentConditionsEntity that = (FulfillmentConditionsEntity) o;

        if (idFulfillmentConditions != null ? !idFulfillmentConditions.equals(that.idFulfillmentConditions) : that.idFulfillmentConditions != null)
            return false;
        if (idOrderMaterialCondition != null ? !idOrderMaterialCondition.equals(that.idOrderMaterialCondition) : that.idOrderMaterialCondition != null)
            return false;
        if (idWork != null ? !idWork.equals(that.idWork) : that.idWork != null) return false;
        if (idWorkCondition != null ? !idWorkCondition.equals(that.idWorkCondition) : that.idWorkCondition != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFulfillmentConditions != null ? idFulfillmentConditions.hashCode() : 0;
        result = 31 * result + (idOrderMaterialCondition != null ? idOrderMaterialCondition.hashCode() : 0);
        result = 31 * result + (idWork != null ? idWork.hashCode() : 0);
        result = 31 * result + (idWorkCondition!= null ? idWorkCondition.hashCode() : 0);
        return result;
    }
}

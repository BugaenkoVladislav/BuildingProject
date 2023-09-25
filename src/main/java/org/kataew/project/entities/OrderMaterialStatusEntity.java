package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "order_material_status", schema = "public", catalog = "db")
public class OrderMaterialStatusEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_order_material_status")
    private Long idOrderMaterialStatus;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdOrderMaterialStatus() {
        return idOrderMaterialStatus;
    }

    public void setIdOrderMaterialStatus(Long idOrderMaterialStatus) {
        this.idOrderMaterialStatus = idOrderMaterialStatus;
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

        OrderMaterialStatusEntity that = (OrderMaterialStatusEntity) o;

        if (idOrderMaterialStatus != null ? !idOrderMaterialStatus.equals(that.idOrderMaterialStatus) : that.idOrderMaterialStatus != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrderMaterialStatus != null ? idOrderMaterialStatus.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


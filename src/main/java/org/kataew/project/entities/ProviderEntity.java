package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "provider", schema = "public", catalog = "db")
public class ProviderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_provider")
    private Long idProvider;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
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

        ProviderEntity that = (ProviderEntity) o;

        if (idProvider != null ? !idProvider.equals(that.idProvider) : that.idProvider != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProvider != null ? idProvider.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


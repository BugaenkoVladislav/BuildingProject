
package org.kataew.project.entities;

import javax.persistence.*;

@Entity
@Table(name = "executor", schema = "public", catalog = "db")
public class ExecutorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_executor")
    private Long idExecutor;
    @Basic
    @Column(name = "count_of_people")
    private Long countOfPeople;
    @Basic
    @Column(name = "experience")
    private Long experience;
    @Basic
    @Column(name = "name")
    private String name;

    public Long getIdExecutor() {
        return idExecutor;
    }

    public void setIdExecutor(Long idExecutor) {
        this.idExecutor = idExecutor;
    }

    public Long getCountOfPeople() {
        return countOfPeople;
    }

    public void setCountOfPeople(Long countOfPeople) {
        this.countOfPeople = countOfPeople;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
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

        ExecutorEntity that = (ExecutorEntity) o;

        if (idExecutor != null ? !idExecutor.equals(that.idExecutor) : that.idExecutor != null) return false;
        if (countOfPeople != null ? !countOfPeople.equals(that.countOfPeople) : that.countOfPeople != null)
            return false;
        if (experience != null ? !experience.equals(that.experience) : that.experience != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idExecutor != null ? idExecutor.hashCode() : 0;
        result = 31 * result + (countOfPeople != null ? countOfPeople.hashCode() : 0);
        result = 31 * result + (experience != null ? experience.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}


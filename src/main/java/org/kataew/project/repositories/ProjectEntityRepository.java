
package org.kataew.project.repositories;


import org.kataew.project.entities.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectEntityRepository extends JpaRepository<ProjectEntity, Long> {

    List<ProjectEntity> getProjectEntitiesByIdUser(Long id);

}


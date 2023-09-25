package org.kataew.project.repositories;


import org.kataew.project.entities.FulfillmentConditionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FulfillmentConditionsRepository extends JpaRepository<FulfillmentConditionsEntity, Long> {
    List<FulfillmentConditionsEntity> findFulfillmentConditionsEntitiesByIdWork(Long workId);
}

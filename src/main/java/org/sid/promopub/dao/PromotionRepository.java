package org.sid.promopub.dao;

import org.sid.promopub.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    @RestResource(path = "/promotionByname")
    Promotion findByName(@Param("name") String name);
}

package org.sid.promopub.dao;

import org.sid.promopub.entities.Promotion;
import org.sid.promopub.entities.Publicite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface PubliciteRepository extends JpaRepository<Publicite,Long> {
    @RestResource(path = "/publiciteByname")
    Publicite findByName(@Param("name") String name);
}

package com.appgate.repository;

import com.appgate.repository.model.AppgateEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AppgateRepository extends CrudRepository<AppgateEntity, Long>{
    @Query("SELECT u FROM appgate u WHERE u.ip_front = ?1")
    Collection<AppgateEntity> findByIpFront(String ip_front);

    @Query("SELECT u FROM appgate u WHERE u.country = ?1")
    Collection<AppgateEntity> findByCountry(String country);
}

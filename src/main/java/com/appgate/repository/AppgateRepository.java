package com.appgate.repository;

import com.appgate.repository.model.AppgateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppgateRepository extends CrudRepository<AppgateEntity, Long>{
}

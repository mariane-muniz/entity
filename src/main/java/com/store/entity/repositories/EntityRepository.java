package com.store.entity.repositories;

import java.util.List;
import java.util.Optional;

import com.store.entity.entities.Entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {
    List<Entity> findAllByOrderByIdDesc();
    Optional<Entity> findOneByName(final String name);
}
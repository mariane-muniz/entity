package com.store.entity.repositories;

import java.util.List;

import com.store.entity.entities.Entity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {
    List<Entity> findAllByOrderByIdDesc();
}
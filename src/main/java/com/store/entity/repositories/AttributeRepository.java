package com.store.entity.repositories;

import java.util.List;

import com.store.entity.entities.Attribute;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttributeRepository extends MongoRepository<Attribute, String> {
    List<Attribute> findAllByOrderByIdDesc();
    List<Attribute> findAllByEntityID(final String entientityIDtyId);
}
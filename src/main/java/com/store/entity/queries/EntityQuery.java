package com.store.entity.queries;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.store.entity.entities.Entity;
import com.store.entity.repositories.EntityRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityQuery implements GraphQLQueryResolver {
    private final EntityRepository entityRepository;

    public List<Entity> findLastEntityRegistered() {
        return this.entityRepository.findAllByOrderByIdDesc();
    }

}
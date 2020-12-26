package com.store.entity.queries;

import java.util.List;
import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.store.entity.entities.Entity;
import com.store.entity.repositories.EntityRepository;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityQuery implements GraphQLQueryResolver {
    private final EntityRepository entityRepository;

    public List<Entity> findLastEntityRegistered() {
        return this.entityRepository.findAllByOrderByIdDesc();
    }

    public Optional<Entity> findOneEntityByName(final String name) {
        Assert.notNull(name, "name cannot be null");
        return this.entityRepository.findOneByName(name);
    }
}
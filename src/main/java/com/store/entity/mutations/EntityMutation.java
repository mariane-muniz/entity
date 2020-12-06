package com.store.entity.mutations;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.store.entity.entities.Entity;
import com.store.entity.inputs.EntityInput;
import com.store.entity.repositories.EntityRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityMutation implements GraphQLMutationResolver {
    private final EntityRepository entityRepository;

    public Entity registerEntity(final EntityInput entityInput) {
        Assert.notNull(entityInput, "entityInput cannot be null");

        Entity entity;
        final String name = entityInput.getName();
        final String id = entityInput.getId();

        if (!StringUtils.isEmpty(id)) {
            entity = this.entityRepository.findById(id).get();
        }
        else {
            entity = new Entity();
            entity.setId(UUID.randomUUID().toString());
        }

        entity.setName(name);

        return this.entityRepository.save(entity);
    }
}
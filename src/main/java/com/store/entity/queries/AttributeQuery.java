package com.store.entity.queries;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.store.entity.entities.Attribute;
import com.store.entity.repositories.AttributeRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributeQuery implements GraphQLQueryResolver {
    private final AttributeRepository attributeRepository;

    public List<Attribute> findLastAttributesRegistered() {
        return this.attributeRepository.findAllByOrderByIdDesc();
    }
}
package com.store.entity.inputs;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityInput implements GraphQLInputType {
    private String id;
    private String name;

    @Override
    public String getName() {
        return this.name;
    }
    
}
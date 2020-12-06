package com.store.entity.inputs;

import graphql.schema.GraphQLInputType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeInput implements GraphQLInputType {
    private String id;
    private String name;
    private String typeCode;
    private String regexValidation;
    private String entityID;

    @Override
    public String getName() {
        return this.name;
    }
    
}
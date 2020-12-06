package com.store.entity.mutations;

import java.util.Arrays;
import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.store.entity.entities.Attribute;
import com.store.entity.enums.NativeTypeEnum;
import com.store.entity.inputs.AttributeInput;
import com.store.entity.repositories.AttributeRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AttributeMutation implements GraphQLMutationResolver {
    private final AttributeRepository attributeRepository;

    public Attribute registerAttribute(final AttributeInput attributeInput) {
        Assert.notNull(attributeInput, "attributeInput cannot be null");

        Attribute entity;
        final String id = attributeInput.getId();

        if (StringUtils.isEmpty(id)) {
            entity = this.attributeRepository.findById(id).get();
        }
        else {
            final String typeCode = attributeInput.getTypeCode();

            entity = new Attribute();
            entity.setId(UUID.randomUUID().toString());
            entity.setEntityID(attributeInput.getEntityID());
            entity.setName(attributeInput.getName());

            Arrays.stream(NativeTypeEnum.values())
                .filter(nativeType -> nativeType.name().equals(typeCode))
                .findFirst().ifPresent(entity::setType);
        }

        entity.setRegexValidation(attributeInput.getRegexValidation());
        

        return entity;
    }
}
package com.store.entity.entities;

import com.store.entity.enums.NativeTypeEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "attributers")
public class Attribute {
    @Id
    private String id;
    private String name;
    private NativeTypeEnum type;
    private String regexValidation;
    private String entityID;
}
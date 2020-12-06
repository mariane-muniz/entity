package com.store.entity.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "entities")
public class Entity {
    @Id
    private String id;
    private String name;
}
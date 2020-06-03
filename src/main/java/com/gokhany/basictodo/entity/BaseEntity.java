package com.gokhany.basictodo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class BaseEntity {

    @Id
    private ObjectId id;

    @Field("create_date")
    private Date createDate;

    BaseEntity(){
        this.createDate = new Date();
    }
}

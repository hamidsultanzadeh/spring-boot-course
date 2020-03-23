package com.hamidsultanzadeh.springbootmongodb.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Account {

    @Id
    private String id;
    private String nameSurname;
    private String phone;
    private String username;

}

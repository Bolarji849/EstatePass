package com.byteBuilders.estatePass.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Tenant {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isLoggedIn;


}

package com.byteBuilders.estatePass.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class Security {
    @Id
    private String id;
    private String Otp;
}

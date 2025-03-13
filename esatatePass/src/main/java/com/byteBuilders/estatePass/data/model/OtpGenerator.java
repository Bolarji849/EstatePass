package com.byteBuilders.estatePass.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
@Document
@Data
public class OtpGenerator {
    @Id
    private String id;
    private String otp;
    private LocalDateTime expirationTime;
    private String name;
    private String email;
    private String phoneNumber;

}

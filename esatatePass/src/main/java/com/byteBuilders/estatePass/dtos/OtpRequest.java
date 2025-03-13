package com.byteBuilders.estatePass.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpRequest {
    private String phoneNumber;
    private String name;
    private String email;

}

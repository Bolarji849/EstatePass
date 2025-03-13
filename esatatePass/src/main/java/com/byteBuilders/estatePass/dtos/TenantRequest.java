package com.byteBuilders.estatePass.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}

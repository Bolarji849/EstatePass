package com.byteBuilders.estatePass.dtos;

import com.byteBuilders.estatePass.data.model.OtpGenerator;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class VisitorsRequest {
    private String visitorName;
    private String  tenantName;
    private LocalDateTime timestamp;
    private OtpGenerator otpGenerator;
    private String Id;
}

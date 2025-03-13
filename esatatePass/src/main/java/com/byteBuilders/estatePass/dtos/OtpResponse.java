package com.byteBuilders.estatePass.dtos;


import com.byteBuilders.estatePass.data.model.OtpGenerator;
import com.byteBuilders.estatePass.data.model.VisitorPass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpResponse {
    private VisitorPass visitorPass;
    private OtpGenerator otpGenerator;
}

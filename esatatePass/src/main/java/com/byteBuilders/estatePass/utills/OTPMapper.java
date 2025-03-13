package com.byteBuilders.estatePass.utills;

import com.byteBuilders.estatePass.data.model.OtpGenerator;
import com.byteBuilders.estatePass.data.model.VisitorPass;
import com.byteBuilders.estatePass.dtos.OtpResponse;

public class OTPMapper {
    public static OtpResponse mapToOtpResponse(OtpGenerator otp, VisitorPass visitorPass) {
        OtpResponse otpResponse = new OtpResponse();
        otpResponse.setVisitorPass(visitorPass);
        otpResponse.setOtpGenerator(otp);
        return otpResponse;
    }
}

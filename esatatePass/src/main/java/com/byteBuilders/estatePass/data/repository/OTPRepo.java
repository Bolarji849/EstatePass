package com.byteBuilders.estatePass.data.repository;

import com.byteBuilders.estatePass.data.model.OtpGenerator;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OTPRepo extends MongoRepository<OtpGenerator, String> {
    List<OtpGenerator> findGenerateOtpByExpirationTimeBefore(LocalDateTime expirationTime);
   Optional<OtpGenerator> findGenerateOtpByOtp(String otp);
}

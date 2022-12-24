package com.example.paymentservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "payment-service")
public class ApplicationProperties {

    private int unpaidBillCountAllowed;

    private int periodDays;

}

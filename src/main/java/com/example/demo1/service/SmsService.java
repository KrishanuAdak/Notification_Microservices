package com.example.demo1.service;

import com.example.demo1.feign.Fast2SmsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class SmsService {
	
        @Autowired       
	    private final Fast2SmsClient fast2SmsClient;

	    @Value("${fast2sms.api.key}")
	    private String apiKey;

	    public SmsService(Fast2SmsClient fast2SmsClient) {
	        this.fast2SmsClient = fast2SmsClient;
	    }

	    public String sendSms(String number, String message) {
	        return fast2SmsClient.sendSms(
	            apiKey,
	            "FSTSMS",
	            message,
	            "english",
	            "q", // transactional route
	            number
	        );
	    }
	


}

package com.example.demo1.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo1.NotificationResponse.Notification_Details_To_Notification_Service;

@Service
public class CosnumeEvent {
	
	@Autowired
	private SmsService smsService;
	@KafkaListener(topics = "appointment-by-patients-notification", groupId = "notification-group-new")
	public void consume(Notification_Details_To_Notification_Service  event) {
	    System.out.println("New appointment : " + event);
	    String message="Your Appointment has been booked on"+event.getAppointment_scheduled()+"Please don't miss out!";
	    this.smsService.sendSms(event.getPhoneNumber(), message);
	}


}

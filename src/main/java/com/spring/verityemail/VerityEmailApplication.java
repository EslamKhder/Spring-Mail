package com.spring.verityemail;

import com.spring.verityemail.model.Mail;
import com.spring.verityemail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class VerityEmailApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(VerityEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendCV(){
		Mail mail = new Mail();
		mail.setHeader("CV Eslam Khder");
		mail.setTo("eslamkhder81@gmail.com");
		mail.setText("Success Eslam Thanks for you");
		emailService.sendMessageByMail(mail);
		System.out.println("OK");
	}
}
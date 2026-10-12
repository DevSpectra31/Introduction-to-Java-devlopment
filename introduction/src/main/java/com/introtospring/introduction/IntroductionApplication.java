package com.introtospring.introduction;

import com.introtospring.introduction.implementation.EmailNotificatiion;
import com.introtospring.introduction.implementation.SmsNotfication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@SpringBootApplication
public class IntroductionApplication implements CommandLineRunner {
	//@Autowired
	private final Notification smsNotficationob ;
	// constructor di technique - >

	public IntroductionApplication(  Notification  smsNotficationob){
		this.smsNotficationob=smsNotficationob;
	}
    public static void main(String[] args) {

		SpringApplication.run(IntroductionApplication.class, args);
	}

	public  void run(String []args) throws  Exception {
		smsNotficationob.send("hello");
	}
}

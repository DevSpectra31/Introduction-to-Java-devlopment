package com.introtospring.introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionApplication implements CommandLineRunner {
	@Autowired
	PaymentService paymentservicepay1 ;
	@Autowired
	PaymentService getPaymentservicepay2;

    public static void main(String[] args) {

		SpringApplication.run(IntroductionApplication.class, args);
	}

	public  void run(String []args) throws  Exception {
		System.out.println(paymentservicepay1.hashCode());
		System.out.println(getPaymentservicepay2.hashCode());
	paymentservicepay1.pay();
	getPaymentservicepay2.pay();
	}
}

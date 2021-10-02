package com.pgr.springboot.FirstSpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pgr.springboot.FirstSpringBootApplication.service.MessageService;

@SpringBootApplication

/*@EnableAutoConfiguration
@ComponentScan
@Configuration*/
public class FirstSpringBootApplication implements CommandLineRunner {

	@Autowired
	MessageService messageService;
	
	/*
	 * public void setMessageService(MessageService messageService) {
	 * this.messageService = messageService; }
	 * 
	 * @Bean(name = "messageService") public MessageService getMessageService() {
	 * return messageService; }
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Hello First Spring Boot Application");
		SpringApplication.run(FirstSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(messageService.message());
	}

}

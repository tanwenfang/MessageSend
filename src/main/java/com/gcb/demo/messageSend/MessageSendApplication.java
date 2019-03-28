package com.gcb.demo.messageSend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.gcb.demo.messageSend"})
public class MessageSendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageSendApplication.class, args);
	}

}

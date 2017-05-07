package com.apps.rabbitmq;

import java.util.Date;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RabbitmqTestController {

	@RequestMapping(value = "/rabbit")
	public String home() throws InterruptedException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        RabbitTemplate rabbitTemplate = ctx.getBean(RabbitTemplate.class);
        String date = new Date().toString();
//        AtomicInteger counter = new AtomicInteger();
        for (int i = 0; i < 1; i++){
            System.out.println("sending new custom message..");
            rabbitTemplate.convertAndSend(date + String.valueOf(i));
        }

		return "rabbitForm";
	}
}

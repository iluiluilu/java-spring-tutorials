package com.apps.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RabbitMQlListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mail.xml");
        String messageBody = new String(message.getBody());
        Mail mm = (Mail) context.getBean("mailSmtp");
        mm.sendMail("from@no-spam.com", "receive email", messageBody, "Date is: " + messageBody);

        // TODO Auto-generated method stub

        System.out.println("Listener received message----->" + messageBody);
    }

}

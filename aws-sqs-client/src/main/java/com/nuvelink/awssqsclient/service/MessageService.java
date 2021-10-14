package com.nuvelink.awssqsclient.service;

import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSSession;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.nuvelink.awssqsclient.utils.MessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;

@Service
public class MessageService {

    Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private MessageFactory messageFactory;

    private SQSConnection connection;

    private Session session;

    
    @PostConstruct   // after Creating bean init() will be execute.
    public void initSQSSession() {
        try {
			this.connection = messageFactory.getConnection();
	        this.session = connection.createSession(false, SQSSession.CLIENT_ACKNOWLEDGE);
	        System.out.println("Called One Time");
		} catch (JMSException e) {
			LOGGER.error("Error: initSQSSession()", e);
		}
       
    }

    public <T> void send(String targetQueueName, T object)  throws JMSException {
        Queue queue = session.createQueue(targetQueueName);
        MessageProducer producer = session.createProducer(queue);
        ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(object);
	        ObjectMessage message = session.createObjectMessage(jsonString);
	        producer.send(message);
	        LOGGER.info("Message sent to "+ targetQueueName);
		} catch (JsonProcessingException e) {
			LOGGER.error("Error while sending message to queue:", e);
		}
      
    }

    public <T> T receive(String queueName, Class<T> targetClass) throws JMSException {
        Object finalObject = new Object();
        Queue queue = session.createQueue(queueName);
        MessageConsumer consumer = session.createConsumer(queue);
        connection.start();
        Message receivedMessage = consumer.receive(1000);
        if (receivedMessage != null) {
        	String  json= ((ObjectMessage)receivedMessage).getObject().toString();
        	Gson gson = new Gson();
            finalObject =  gson.fromJson(json, targetClass);
        	 receivedMessage.acknowledge();
        }
        connection.stop();
        LOGGER.info("Message from queue:"+ finalObject);
        return (T) finalObject;
    }
}

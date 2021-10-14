package com.middleware.nuvelink.amazon.sqs.service;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.middleware.nuvelink.amazon.sqs.config.AwsSqsConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import java.util.concurrent.TimeUnit;

@Service
public class AwsSqsSenderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsSqsSenderService.class);

    @Value("${awssqs.base.cloud.end-point.uri}")
    private String sqsBaseUrl;

    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;


    public <T> void send(String targetQueueName, T object) {
        try {
            queueMessagingTemplate.convertAndSend(sqsBaseUrl+targetQueueName, object);
        } catch (Exception e) {
            LOGGER.error("Error While sending the message to queue():", e);
        }
    }

    public <T> T receiveAndConvert(String destinationQueueName, Class<T> targetClass) {
        try {
            SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
                    new ProviderConfiguration(),
                    AmazonSQSClientBuilder.standard()
                            .withRegion(Regions.US_EAST_2)
                            .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey))));
            // Create the connection
            SQSConnection connection = connectionFactory.createConnection();

            // Create the session
            Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer( session.createQueue( destinationQueueName ) );

            connection.start();

            receiveMessages(session, consumer);

            // Close the connection. This closes the session automatically
            connection.close();
            System.out.println( "Connection closed" );
            //return queueMessagingTemplate.receiveAndConvert(destinationQueueName, targetClass);
        } catch (Exception e) {
            LOGGER.error("Error While receiving the message from queue():", e);
        }
        return null;
    }


    private static  Object receiveMessages( Session session, MessageConsumer consumer ) {
        try {
            while( true ) {
                System.out.println( "Waiting for messages");
                // Wait 1 minute for a message
                Message message = consumer.receive(TimeUnit.MINUTES.toMillis(1));
                if( message == null ) {
                    System.out.println( "Shutting down after 1 minute of silence" );
                    break;
                }
                message.acknowledge();
                System.out.println(message);
                System.out.println( "Acknowledged message " + message.getJMSMessageID() );
                return message;
            }
        } catch (JMSException e) {
            System.err.println( "Error receiving from SQS: " + e.getMessage() );
            e.printStackTrace();
        }
        return null;
    }
}

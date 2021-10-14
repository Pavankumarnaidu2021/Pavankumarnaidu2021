package com.nuvelink.awssqsclient.utils;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.util.StringUtils;
import com.nuvelink.awssqsclient.exception.QueueNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class MessageFactory {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageFactory.class);

    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    private SQSConnection connection;

    @Bean
    @Primary
    public SQSConnection getConnection() throws JMSException {
        if (connection == null) {
            SQSConnectionFactory connectionFactory = new SQSConnectionFactory(new ProviderConfiguration(),
                    AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_2)
                            .withCredentials(new AWSStaticCredentialsProvider
                                    (new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                            .build());
            this.connection = connectionFactory.createConnection();
        }
        return connection;
    }

    public static String getOriginalQueueNameFromAllQueues(String publisherQueueNames, String awsQueueName) {
        if (!StringUtils.isNullOrEmpty(publisherQueueNames) && !StringUtils.isNullOrEmpty(awsQueueName)) {
            List<String> publisherQueueList = Arrays.asList(publisherQueueNames.split(","));
            if (!publisherQueueList.contains(awsQueueName)) {
                LOGGER.error("QueueNotFoundException");
                throw new QueueNotFoundException("Queue not matched for a given queue: " + awsQueueName);
            }
        }
        return awsQueueName;
    }
}

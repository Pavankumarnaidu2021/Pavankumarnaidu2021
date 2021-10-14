package com.middleware.nuvelink.amazon.sqs.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.util.StringUtils;
import com.middleware.nuvelink.amazon.sqs.exception.QueueNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class AwsSqsConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsSqsConfiguration.class);

    public static final String AWS_SQS_BASE_URL = "/messages";

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate() {
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    @Primary
    @Bean
    public AmazonSQSAsync amazonSQSAsync() {
        return AmazonSQSAsyncClientBuilder.standard().withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey)))
                .build();
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


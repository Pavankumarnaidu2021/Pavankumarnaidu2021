package com.middleware.nuvelink.amazon.sqs.controller;

import com.amazonaws.util.StringUtils;
import com.middleware.nuvelink.amazon.sqs.config.AwsSqsConfiguration;
import com.middleware.nuvelink.amazon.sqs.constants.AwsSqsConstants;
import com.middleware.nuvelink.amazon.sqs.models.JSONData;
import com.middleware.nuvelink.amazon.sqs.service.AwsSqsSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AwsSqsConfiguration.AWS_SQS_BASE_URL)
public class AwsSqsMessagingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AwsSqsMessagingController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private AwsSqsSenderService sqsSenderService;


    @PostMapping("/send/{awsQueueName}")
    public void sendMessageToQueue(@RequestBody JSONData jsonData, @PathVariable("awsQueueName") String awsQueueName) {
        String publisherQueueNames = environment.getProperty(AwsSqsConstants.AWS_SQS_ALL_QUEUES);
        String originalQueueName = AwsSqsConfiguration.getOriginalQueueNameFromAllQueues(publisherQueueNames, awsQueueName);
        sqsSenderService.send(originalQueueName, jsonData);
    }

    @GetMapping("receive/{awsQueueName}")
    public ResponseEntity reciveMessagesFromQueue(@PathVariable("awsQueueName") String awsQueueName) {
        String publisherQueueNames = environment.getProperty(AwsSqsConstants.AWS_SQS_ALL_QUEUES);
        String originalQueueName = AwsSqsConfiguration.getOriginalQueueNameFromAllQueues(publisherQueueNames, awsQueueName);
        if (!StringUtils.isNullOrEmpty(originalQueueName)) {
            JSONData jsonData = sqsSenderService.receiveAndConvert(originalQueueName, JSONData.class);
            return new ResponseEntity(jsonData, HttpStatus.OK);
        }
        return new ResponseEntity("Error while calling reciveMessagesFromQueue()", HttpStatus.BAD_REQUEST);
    }

    /*@SqsListener(value = "${aws.sqs.queue.name}")
    public void getMessagesFormAwsSQSQueus(JSONData jsonData) {
        LOGGER.info("Messages From AWS SQS Queue {}", jsonData);
    }*/
}


package com.nuvelink.awssqsclient.controller;

import javax.jms.JMSException;

import com.nuvelink.awssqsclient.constants.AwsSqsConstants;
import com.nuvelink.awssqsclient.utils.MessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuvelink.awssqsclient.models.MessageRequest;
import com.nuvelink.awssqsclient.models.MessageResponse;
import com.nuvelink.awssqsclient.service.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "AWSSQS")
@RestController
@RequestMapping("/api/")
public class AwsSQSController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private Environment environment;

    @ApiOperation(value = "Produce Message to AWS SQS Queue", nickname = "produceMessage",
            notes = "Produce Message to AWS SQS Queue", tags = "AWS SQS Produce and Consume")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "successfully created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Authentication Failed"),
            @ApiResponse(code = 403, message = "Unauthorised"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @PostMapping(value = "/send/{awsQueueName}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> sendMessagesToQueue(
            @ApiParam(value = "Message needs to be added to the queue", required = true)
            @RequestBody MessageRequest messageRequest,
            @PathVariable String awsQueueName) throws JMSException {
        String publisherQueueNames = environment.getProperty(AwsSqsConstants.AWS_SQS_ALL_QUEUES);
        String originalQueueName = MessageFactory.getOriginalQueueNameFromAllQueues(publisherQueueNames, awsQueueName);
        if (originalQueueName != null) {
            messageService.send(originalQueueName, messageRequest);
        }
        return new ResponseEntity("Messages Sent to " + awsQueueName, HttpStatus.OK);
    }

    @ApiOperation(value = "Produce Message to AWS SQS Queue", nickname = "produceMessage",
            notes = "Produce Message to AWS SQS Queue", tags = "AWS SQS Produce and Consume")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "successful operation"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Authentication Failed"),
            @ApiResponse(code = 403, message = "Unauthorised"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 500, message = "Internal server error")})
    @GetMapping(value = "/receive/{awsQueueName}", produces = {"application/json"})
    public ResponseEntity<?> recieveMessage(
            @ApiParam(value = "SQS Queue Name", required = true) @PathVariable("awsQueueName") String awsQueueName)
            throws JMSException {
        MessageResponse messageResponse = new MessageResponse();
        String publisherQueueNames = environment.getProperty(AwsSqsConstants.AWS_SQS_ALL_QUEUES);
        String originalQueueName = MessageFactory.getOriginalQueueNameFromAllQueues(publisherQueueNames, awsQueueName);
        if (originalQueueName != null) {
            messageResponse = messageService.receive(awsQueueName, MessageResponse.class);
        }
        return new ResponseEntity(messageResponse, HttpStatus.OK);
    }

}

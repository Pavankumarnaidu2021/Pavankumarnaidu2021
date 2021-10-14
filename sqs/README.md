# Amazon Simple Queue Service
This is the spring boot application which can be used as the interface for the amazonSQS. This module is designed such a way that it can publish to multiple queue and it can be subscribe to multiple listners. All these are configurable in the properties file

# Mandatory application properties
1. cloud.aws.region.static=<aws regoin>
2. cloud.aws.stack.auto=false
3. cloud.aws.credentials.access-key=<Access key for the IAM or Root User>
4. cloud.aws.credentials.secret-key=<Secret key for the IAM or Root User>
5. awssqs.publisher.configuration.prefix=cloulabs-queue,test-sqs-queue,test-aws-queue
6. awssqs.base.cloud.end-point.uri=https://sqs.us-east-2.amazonaws.com/744126532828/

# How to configure multiple publisher dynamically
1. Add comma separated value to the property 'awssqs.publisher.configuration.prefix' which will be treated as the prefix for the different configuration.
    1. Eg: **awssqs.publisher.configuration.prefix=cloulabs-queue,test-sqs-queue**
    2. In the above example we are creating 2 publishers with the prefix cloulabs-queue and test-sqs-queue.
2. Define the End Point Url without specifying the queue name.
    1. Eg: **awssqs.base.cloud.end-point.uri=https://sqs.us-east-2.amazonaws.com/744126532828/**
    2. In the above example we are adding the Queue URL without queue name.
    3. But out actual URL will look like **awssqs.base.cloud.end-point.uri=https://sqs.us-east-2.amazonaws.com/744126532828/cloulabs-queue** this.
Note: The Url we will get it form AWS, After creating the new Queue in Amazon Simple Queue Service
    
# How to publish the message to Amazon Simple Queue Service
1. Autowired the `QueueMessagingTemplate` in your service
   1. `private QueueMessagingTemplate queueMessagingTemplate;`
2. Send the Message to desired queue using Configuration prefix queue name as follows
   1. `queueMessagingTemplate.convertAndSend(<targetQueueName>, <Object>);`
3. The above example is for sending the Object to the Queue, We can send the sting messages to the Queue
   1.`queueMessagingTemplate.send(<targetQueueName>, <Object>);`
   
# How to configure multiple subscriber dynamically
1. Autowired the `QueueMessagingTemplate` in your service
    1. `private QueueMessagingTemplate queueMessagingTemplate;`
2. Receive the Message from desired queue using Configuration prefix queue name as follows
    1. `queueMessagingTemplate.receiveAndConvert(<destinationQueueName>, <Class<T>>);`
3. The above example is for receive the Object to the Queue, We can receive the sting messages from the Queue
   1.`queueMessagingTemplate.receive(<destinationQueueName>);`

# How to implement the static Message Listener
1. Create the service class, Annotate with `@Service(<ServiceName>)`.
2. Define void method in service and must Annotate with `@SqsListener(value = "${aws.sqs.queue.name}")`
   here the Value will take Queue name as a parameter will get form properties file, Or we can define as a variable in current class.
    e.g.,

````
   @SqsListener(value = "${aws.sqs.queue.name}")
    public void getMessagesFormAwsSQSQueus(JSONData jsonData) {
        LOGGER.info("Messages From AWS SQS Queue {}", jsonData);
    }
````
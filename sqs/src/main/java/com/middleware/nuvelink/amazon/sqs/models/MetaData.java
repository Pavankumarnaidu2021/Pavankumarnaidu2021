package com.middleware.nuvelink.amazon.sqs.models;

public class MetaData {

    private String messageName;
    private String messageId;
    private String category;
    private String messageType;
    private String priority;
    private String level;
    private String recipientType;
    private String contentType;
    private String encType;
    private String source;
    private String createdOn;
    private String expiryOn;

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getEncType() {
        return encType;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getExpiryOn() {
        return expiryOn;
    }

    public void setExpiryOn(String expiryOn) {
        this.expiryOn = expiryOn;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "messageName='" + messageName + '\'' +
                ", messageId='" + messageId + '\'' +
                ", category='" + category + '\'' +
                ", messageType='" + messageType + '\'' +
                ", priority='" + priority + '\'' +
                ", level='" + level + '\'' +
                ", recipientType='" + recipientType + '\'' +
                ", contentType='" + contentType + '\'' +
                ", encType='" + encType + '\'' +
                ", source='" + source + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", expiryOn='" + expiryOn + '\'' +
                '}';
    }
}

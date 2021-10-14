package com.middleware.nuvelink.amazon.sqs.models;

public class Data {

    private String requestedOn;
    private String createdOn;
    private String updatedOn;
    private String expiredOn;
    private String action;
    private String status;
    private String lastAction;
    private String lastActionStatus;
    private String actionTriggerType;
    private String actionTriggerReason;
    private String userAccess;
    private String isLocked;

    public String getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(String requestedOn) {
        this.requestedOn = requestedOn;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }

    public String getExpiredOn() {
        return expiredOn;
    }

    public void setExpiredOn(String expiredOn) {
        this.expiredOn = expiredOn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLastAction() {
        return lastAction;
    }

    public void setLastAction(String lastAction) {
        this.lastAction = lastAction;
    }

    public String getLastActionStatus() {
        return lastActionStatus;
    }

    public void setLastActionStatus(String lastActionStatus) {
        this.lastActionStatus = lastActionStatus;
    }

    public String getActionTriggerType() {
        return actionTriggerType;
    }

    public void setActionTriggerType(String actionTriggerType) {
        this.actionTriggerType = actionTriggerType;
    }

    public String getActionTriggerReason() {
        return actionTriggerReason;
    }

    public void setActionTriggerReason(String actionTriggerReason) {
        this.actionTriggerReason = actionTriggerReason;
    }

    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    @Override
    public String toString() {
        return "Data{" +
                "requestedOn='" + requestedOn + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", expiredOn='" + expiredOn + '\'' +
                ", action='" + action + '\'' +
                ", status='" + status + '\'' +
                ", lastAction='" + lastAction + '\'' +
                ", lastActionStatus='" + lastActionStatus + '\'' +
                ", actionTriggerType='" + actionTriggerType + '\'' +
                ", actionTriggerReason='" + actionTriggerReason + '\'' +
                ", userAccess='" + userAccess + '\'' +
                ", isLocked='" + isLocked + '\'' +
                '}';
    }
}

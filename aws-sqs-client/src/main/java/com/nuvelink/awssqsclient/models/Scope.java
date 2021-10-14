package com.nuvelink.awssqsclient.models;

import java.io.Serializable;

public class Scope implements Serializable {

    private String language;
    private String appId;
    private String scope;
    private String identity;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Scope{" +
                "language='" + language + '\'' +
                ", appId='" + appId + '\'' +
                ", scope='" + scope + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}

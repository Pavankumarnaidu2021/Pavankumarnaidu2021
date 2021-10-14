package com.nuvelink.awssqsclient.models;

import java.io.Serializable;

public class MessageRequest implements Serializable {

    private MetaData metadata;
    private Data data;
    private Scope scope;

    public MetaData getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaData metadata) {
        this.metadata = metadata;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "JSONData{" +
                "metadata=" + metadata +
                ", data=" + data +
                ", scope=" + scope +
                '}';
    }
}

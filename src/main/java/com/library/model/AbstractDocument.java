package com.library.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by Dmytro on 8/6/2014.
 */
//TODO: docs
public abstract class AbstractDocument implements Serializable {

    protected static final long serialVersionUID = -425963247051905484L;
    @Id
    protected String objectId;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}

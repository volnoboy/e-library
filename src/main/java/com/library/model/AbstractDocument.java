package com.library.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 * Created by Dmytro on 8/6/2014.
 */
public abstract class AbstractDocument implements Serializable {

    // what access-modifier for serialVersionUID we need to set? private would be enough?
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

package org.core.domain;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    protected long id;

    protected long getId() {
        return id;
    }
}

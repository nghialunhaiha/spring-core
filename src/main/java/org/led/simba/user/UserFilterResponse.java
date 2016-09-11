package org.led.simba.user;

import org.core.domain.BaseEntity;

public class UserFilterResponse extends BaseEntity {

    private String userName;
    private String village;

    public UserFilterResponse() {
    }

    public UserFilterResponse(long id, String userName, String village) {
        this.id = id;
        this.userName = userName;
        this.village = village;
    }

    public String getUserName() {
        return userName;
    }

    public String getVillage() {
        return village;
    }
}

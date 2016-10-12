package org.led.simba.common;

import javax.persistence.*;

import static org.led.simba.user.UserConstants.USER_ID;

/**
 * Created by Nghia on 03-10-2016.
 */
@MappedSuperclass
public abstract class BaseDomain {
    @Id
    @Column(name = USER_ID)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
}

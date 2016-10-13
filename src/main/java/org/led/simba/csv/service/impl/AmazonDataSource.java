package org.led.simba.csv.service.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

@Component
public class AmazonDataSource implements InitializingBean {

    @Autowired
    Environment environment;

    protected AWSCredentials awsCredentials;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.awsCredentials = new BasicAWSCredentials(environment.getProperty("s3.accessKeyId"),
                environment.getProperty("s3.secretAccessKey"));
    }

}

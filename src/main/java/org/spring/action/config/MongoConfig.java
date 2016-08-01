package org.spring.action.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

// @Configuration
@EnableMongoRepositories(basePackages = { "package.to.scan" })
public class MongoConfig extends AbstractMongoConfiguration {

    @Autowired
    Environment env;

    @Override
    protected String getDatabaseName() {
        return env.getProperty("mongo.db");
    }

    @Override
    public Mongo mongo() throws Exception {
        final int availableCores = Runtime.getRuntime().availableProcessors();
        final float threadsPerCore = Float.parseFloat(env.getProperty("runtime.threads-per-core"));
        final float connectionsPerThread = Float.parseFloat(env.getProperty("runtime.mongo-connections-per-thread"));
        return new MongoClient(
                new ServerAddress(env.getProperty("mongo.host"), Integer.parseInt(env.getProperty("mongo.port"))),
                new MongoClientOptions.Builder()
                        .connectionsPerHost((int) (availableCores * threadsPerCore * connectionsPerThread)).build());
    }

}

package com.assignment.util;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.assignment.util.Figureonverter.StatusConverter;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories("com.assignment.repository")
public class MongoDBConfig {
	@Autowired
    private MongoProperties mongoProperties;

    @Autowired
    private MongoClient mongoClient;


    @Bean
    public MongoTemplate mongoTemplate() {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, mongoProperties.getDatabase());
        MappingMongoConverter mongoMapping = (MappingMongoConverter) mongoTemplate.getConverter();
        mongoMapping.setCustomConversions(customConversions()); // tell mongodb to use the custom converters
        mongoMapping.afterPropertiesSet();
        return mongoTemplate;

    }


    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(Collections.singletonList(new StatusConverter()));
    }

}

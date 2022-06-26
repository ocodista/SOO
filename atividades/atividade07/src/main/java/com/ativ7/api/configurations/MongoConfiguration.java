package com.ativ7.api.configurations;

import com.ativ7.api.mongo.repositories.LocacaoMongoRepository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = LocacaoMongoRepository.class)
public class MongoConfiguration {
}

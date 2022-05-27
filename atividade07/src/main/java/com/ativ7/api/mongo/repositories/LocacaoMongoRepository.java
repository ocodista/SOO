package com.ativ7.api.mongo.repositories;

import com.ativ7.api.mongo.documents.LocacaoDocument;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoMongoRepository extends MongoRepository<LocacaoDocument, Long> {
}

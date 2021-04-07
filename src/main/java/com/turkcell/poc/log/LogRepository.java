package com.turkcell.poc.log;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<LogCollection, String> {
}

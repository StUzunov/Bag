package com.Bag.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagUserRepository extends MongoRepository<BagUser, String> {
    BagUser findByUsername(String username);
}

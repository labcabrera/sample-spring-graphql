package com.github.labcabrera.samples.graphql.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.github.labcabrera.samples.graphql.model.Race;

public interface RaceRepository extends ReactiveMongoRepository<Race, String> {

}

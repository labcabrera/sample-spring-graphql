package com.github.labcabrera.samples.graphql.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.github.labcabrera.samples.graphql.model.Profession;

public interface ProfessionRepository extends ReactiveMongoRepository<Profession, String> {

}

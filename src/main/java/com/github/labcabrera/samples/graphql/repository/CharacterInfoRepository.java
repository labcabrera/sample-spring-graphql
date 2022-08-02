package com.github.labcabrera.samples.graphql.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.github.labcabrera.samples.graphql.model.CharacterInfo;

public interface CharacterInfoRepository extends ReactiveMongoRepository<CharacterInfo, String> {

}

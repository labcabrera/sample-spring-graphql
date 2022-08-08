package com.github.labcabrera.samples.graphql.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.github.labcabrera.samples.graphql.model.Skill;

public interface SkillRepository extends ReactiveMongoRepository<Skill, String> {

}

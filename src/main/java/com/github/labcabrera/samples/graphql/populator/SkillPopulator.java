package com.github.labcabrera.samples.graphql.populator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.labcabrera.samples.graphql.model.Skill;
import com.github.labcabrera.samples.graphql.model.SkillType;
import com.github.labcabrera.samples.graphql.repository.SkillRepository;

@Component
class SkillPopulator implements ApplicationRunner {

	@Autowired
	private SkillRepository repository;

	@Override
	public void run(ApplicationArguments args) {
		List<Skill> races = Arrays.asList(
			Skill.builder()
				.id("perception")
				.name("Perception")
				.type(SkillType.STATIC)
				.build());

		repository.deleteAll()
			.thenMany(repository.saveAll(races))
			.subscribe();
	}

}
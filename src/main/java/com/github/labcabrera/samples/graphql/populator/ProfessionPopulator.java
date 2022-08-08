package com.github.labcabrera.samples.graphql.populator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.labcabrera.samples.graphql.model.Profession;
import com.github.labcabrera.samples.graphql.repository.ProfessionRepository;

@Component
class ProfessionPopulator implements ApplicationRunner {

	@Autowired
	private ProfessionRepository repository;

	@Override
	public void run(ApplicationArguments args) {
		List<Profession> races = Arrays.asList(
			Profession.builder()
				.id("rogue")
				.name("Rogue")
				.build(),
			Profession.builder()
				.id("alchemist")
				.name("alchemist")
				.build());

		repository.deleteAll()
			.thenMany(repository.saveAll(races))
			.subscribe();
	}

}
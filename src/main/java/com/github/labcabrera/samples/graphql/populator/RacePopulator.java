package com.github.labcabrera.samples.graphql.populator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.labcabrera.samples.graphql.model.Race;
import com.github.labcabrera.samples.graphql.repository.RaceRepository;

@Component
class RacePopulator implements ApplicationRunner {

	@Autowired
	private RaceRepository repository;

	@Override
	public void run(ApplicationArguments args) {
		List<Race> races = Arrays.asList(
			Race.builder()
				.id("maia")
				.name("Maia")
				.build(),
			Race.builder()
				.id("hobbit")
				.name("Hobbit")
				.build());

		repository.deleteAll()
			.thenMany(repository.saveAll(races))
			.subscribe();
	}

}
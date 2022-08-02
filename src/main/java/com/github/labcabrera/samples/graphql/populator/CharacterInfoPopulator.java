package com.github.labcabrera.samples.graphql.populator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.labcabrera.samples.graphql.model.CharacterInfo;
import com.github.labcabrera.samples.graphql.repository.CharacterInfoRepository;

@Component
class CharacterInfoPopulator implements ApplicationRunner {

	@Autowired
	private CharacterInfoRepository repository;

	@Override
	public void run(ApplicationArguments args) {
		List<CharacterInfo> characters = Arrays.asList(
			CharacterInfo.builder()
				.id("sauron")
				.name("Sauron")
				.raceId("maia")
				.level(500)
				.build(),
			CharacterInfo.builder()
				.id("gollum")
				.name("Gollum")
				.raceId("hobbit")
				.level(15)
				.build());

		repository.deleteAll()
			.thenMany(repository.saveAll(characters))
			.subscribe();
	}

}
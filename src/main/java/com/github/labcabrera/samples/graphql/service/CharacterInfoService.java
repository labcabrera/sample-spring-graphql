package com.github.labcabrera.samples.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.labcabrera.samples.graphql.controller.dto.CharacterInfoCreation;
import com.github.labcabrera.samples.graphql.model.CharacterInfo;
import com.github.labcabrera.samples.graphql.repository.CharacterInfoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class CharacterInfoService {

	@Autowired
	private CharacterInfoRepository characterInfoRepository;

	public Flux<CharacterInfo> findAll() {
		return characterInfoRepository.findAll();
	}

	public Mono<CharacterInfo> findById(String characterId) {
		return characterInfoRepository.findById(characterId);
	}

	public Mono<CharacterInfo> createCharacter(CharacterInfoCreation request) {
		CharacterInfo characterInfo = CharacterInfo.builder()
			.id(request.getId())
			.name(request.getName())
			.raceId(request.getRaceId())
			.professionId(request.getProfessionId())
			.level(request.getLevel())
			.build();
		return characterInfoRepository.save(characterInfo);
	}

}

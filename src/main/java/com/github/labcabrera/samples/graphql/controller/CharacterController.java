package com.github.labcabrera.samples.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.github.labcabrera.samples.graphql.controller.dto.CharacterInfoCreation;
import com.github.labcabrera.samples.graphql.controller.dto.CharacterSkillDto;
import com.github.labcabrera.samples.graphql.model.CharacterInfo;
import com.github.labcabrera.samples.graphql.model.Profession;
import com.github.labcabrera.samples.graphql.model.Race;
import com.github.labcabrera.samples.graphql.model.Skill;
import com.github.labcabrera.samples.graphql.repository.ProfessionRepository;
import com.github.labcabrera.samples.graphql.repository.RaceRepository;
import com.github.labcabrera.samples.graphql.service.CharacterInfoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CharacterController {

	@Autowired
	private CharacterInfoService characterInfoService;

	@Autowired
	private RaceRepository raceRepository;

	@Autowired
	private ProfessionRepository professionRepository;

	//@Autowired
	//private SkillRepository skillRepository;

	@QueryMapping
	public Flux<CharacterInfo> characters() {
		return characterInfoService.findAll();
	}

	@SchemaMapping
	public Mono<Race> race(CharacterInfo characterInfo) {
		return characterInfo.getRaceId() == null ? Mono.empty() : raceRepository.findById(characterInfo.getRaceId());
	}

	@SchemaMapping
	public Mono<Profession> profession(CharacterInfo characterInfo) {
		return characterInfo.getProfessionId() == null ? Mono.empty() : professionRepository.findById(characterInfo.getProfessionId());
	}

	@SchemaMapping
	public Flux<CharacterSkillDto> skills(CharacterInfo characterInfo) {
		if (characterInfo.getCharacterSkills() == null || characterInfo.getCharacterSkills().isEmpty()) {
			return Flux.empty();
		}
		return Flux.fromIterable(characterInfo.getCharacterSkills())
			.map(e -> CharacterSkillDto.builder()
				.skill(Skill.builder()
					.id(e.getSkillId())
					.build())
				.bonus(e.getBonus())
				.level(e.getLevel())
				.build());
	}

	@MutationMapping
	public Mono<CharacterInfo> createCharacter(@Argument("input") CharacterInfoCreation request) {
		return characterInfoService.createCharacter(request);
	}

}

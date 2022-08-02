package com.github.labcabrera.samples.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.github.labcabrera.samples.graphql.controller.dto.CharacterInfoCreation;
import com.github.labcabrera.samples.graphql.model.CharacterInfo;
import com.github.labcabrera.samples.graphql.service.CharacterInfoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class CharacterController {

	@Autowired
	private CharacterInfoService characterInfoService;

	@QueryMapping
	public Flux<CharacterInfo> characters() {
		return characterInfoService.findAll();
	}

	@MutationMapping
	public Mono<CharacterInfo> createCharacter(@Argument("input") CharacterInfoCreation request) {
		return characterInfoService.createCharacter(request);
	}

}

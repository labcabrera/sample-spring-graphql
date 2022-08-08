package com.github.labcabrera.samples.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.github.labcabrera.samples.graphql.model.Profession;
import com.github.labcabrera.samples.graphql.repository.ProfessionRepository;

import reactor.core.publisher.Flux;

@Controller
public class ProfessionController {

	@Autowired
	private ProfessionRepository professionRepository;

	@QueryMapping
	public Flux<Profession> professions() {
		return professionRepository.findAll();
	}

}

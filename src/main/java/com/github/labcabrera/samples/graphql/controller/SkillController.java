package com.github.labcabrera.samples.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.github.labcabrera.samples.graphql.model.Skill;
import com.github.labcabrera.samples.graphql.repository.SkillRepository;

import reactor.core.publisher.Flux;

@Controller
public class SkillController {

	@Autowired
	private SkillRepository skillRepository;

	@QueryMapping
	public Flux<Skill> skills() {
		return skillRepository.findAll();
	}

}

package com.github.labcabrera.samples.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.github.labcabrera.samples.graphql.model.Race;
import com.github.labcabrera.samples.graphql.repository.RaceRepository;

import reactor.core.publisher.Flux;

@Controller
public class RaceController {

	@Autowired
	private RaceRepository raceRepository;

	@QueryMapping
	public Flux<Race> races() {
		return raceRepository.findAll();
	}

}

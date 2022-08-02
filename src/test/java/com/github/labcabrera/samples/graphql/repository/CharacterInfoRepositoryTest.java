package com.github.labcabrera.samples.graphql.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.labcabrera.samples.graphql.model.CharacterInfo;

@SpringBootTest
class CharacterInfoRepositoryTest {

	@Autowired
	private CharacterInfoRepository repository;

	@Test
	void test() {
		List<CharacterInfo> list = repository.findAll().collectList().share().block();
		assertFalse(list.isEmpty());
	}

}

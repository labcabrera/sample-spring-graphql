package com.github.labcabrera.samples.graphql.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Skill {

	@Id
	private String id;

	private String name;

	private SkillType type;

}

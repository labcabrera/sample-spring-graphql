package com.github.labcabrera.samples.graphql.controller.dto;

import com.github.labcabrera.samples.graphql.model.Skill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterSkillDto {

	private Skill skill;

	private Integer level;

	private Integer bonus;

}

package com.github.labcabrera.samples.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterSkill {

	private String skillId;

	private Integer level;

	private Integer bonus;

}

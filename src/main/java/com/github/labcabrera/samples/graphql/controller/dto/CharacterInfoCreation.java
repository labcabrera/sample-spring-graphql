package com.github.labcabrera.samples.graphql.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterInfoCreation {

	private String id;

	private String name;

	private Integer level;

	private String raceId;

	private String professionId;

}

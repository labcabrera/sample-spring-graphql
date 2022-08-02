package com.github.labcabrera.samples.graphql.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "characterInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterInfo {

	private String id;

	private String name;

	private Integer level;

	private String raceId;

	private String professionId;

}

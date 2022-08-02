package com.github.labcabrera.samples.graphql.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "race")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Race {

	private String id;

	private String name;

}

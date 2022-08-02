package com.github.labcabrera.samples.graphql.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "profession")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profession {

	private String id;

	private String name;

}

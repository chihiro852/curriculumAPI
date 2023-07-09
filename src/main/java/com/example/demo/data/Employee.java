package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Employee {

	@JsonProperty("id")
	private int id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("hometown")
	private String hometown;

	@JsonProperty("joining_month")
	private String joining_month;

	@JsonProperty("created_at")
	private String created_at;

	@JsonProperty("updated_at")
	private String updated_at;

}
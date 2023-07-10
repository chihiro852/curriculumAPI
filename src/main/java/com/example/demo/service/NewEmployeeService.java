package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;

import com.example.demo.repository.NewEmployeeRepository;

@Service
public class NewEmployeeService {

	private final NewEmployeeRepository repository;

	public NewEmployeeService(NewEmployeeRepository repository) {
		this.repository = repository;
	}

	public void postEmployee(String name, String hometown, String joining_month) throws IOException, URISyntaxException {

		if (joining_month == "") {
			repository.postEmployee(name, hometown, joining_month);
		} else {
			repository.postEmployee(name, hometown, joining_month + "-01");
		}

	}

}
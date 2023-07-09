package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.Clock;
import com.example.demo.repository.ShowEmployeeRepository;

@Service
public class ShowEmployeeService {

	private final ShowEmployeeRepository repository;

	public ShowEmployeeService(ShowEmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Clock> getClock(int employeeId) throws IOException, URISyntaxException {

		List<Clock> clocks = repository.getClock(employeeId);

		return clocks;

	}

}
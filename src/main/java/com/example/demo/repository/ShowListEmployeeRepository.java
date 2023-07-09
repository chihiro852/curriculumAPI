package com.example.demo.repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.data.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ShowListEmployeeRepository {

	private static final String BASE_API_URL = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee";
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	public ShowListEmployeeRepository() {
		this.restTemplate = new RestTemplate();
		this.objectMapper = new ObjectMapper();
	}

	public List<Employee> getEmployee(int id) throws IOException, URISyntaxException {
		String apiUrl;

		if (id != 0) {
			apiUrl = BASE_API_URL + "?id=" + id;
		} else {
			apiUrl = BASE_API_URL;
		}

		RequestEntity<Void> request = RequestEntity.get(new URI(apiUrl)).build();

		try {
			ResponseEntity<String> response = restTemplate.exchange(request, String.class);

			String json = response.getBody();

			Employee[] employeeArrays = objectMapper.readValue(json, Employee[].class);

			List<Employee> employees = Arrays.asList(employeeArrays);

			return employees;

		} catch (RestClientException e) {
			throw new IOException("Failed to fetch employee data from the API.", e);
		}
	}
}
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

import com.example.demo.data.Clock;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ShowEmployeeRepository {

	private static final String BASE_API_URL = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/clock?employeeId=";
	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;

	public ShowEmployeeRepository() {
		this.restTemplate = new RestTemplate();
		this.objectMapper = new ObjectMapper();
	}

	public List<Clock> getClock(int employeeId) throws IOException, URISyntaxException {
		String apiUrl = BASE_API_URL + employeeId;

		RequestEntity<Void> request = RequestEntity.get(new URI(apiUrl)).build();

		try {
			ResponseEntity<String> response = restTemplate.exchange(request, String.class);

			String json = response.getBody();

			Clock[] clockArrays = objectMapper.readValue(json, Clock[].class);

			List<Clock> clocks = Arrays.asList(clockArrays);

			return clocks;

		} catch (RestClientException e) {
			throw new IOException("Failed to fetch employee data from the API.", e);
		}
	}
}
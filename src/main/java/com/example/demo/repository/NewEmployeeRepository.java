package com.example.demo.repository;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Repository
public class NewEmployeeRepository {

	private static final String BASE_API_URL = "https://jsn9xu2vsk.execute-api.ap-northeast-1.amazonaws.com/sample/attendanceandabsence/employee";
	private RestTemplate restTemplate;
	private HttpHeaders headers;

	public NewEmployeeRepository() {
		this.restTemplate = new RestTemplate();
		this.headers = new HttpHeaders();
	}

	public void postEmployee(String name, String hometown, String joining_month) throws IOException, URISyntaxException {
		String apiUrl = BASE_API_URL;

		try {
			// リクエストヘッダーの設定
			headers.setContentType(MediaType.APPLICATION_JSON);

			// リクエストボディの設定
			String requestBody = "{\"body\":\"{\\\"name\\\":\\\"" + name + "\\\", \\\"hometown\\\":\\\"" + hometown + "\\\", \\\"joining_month\\\":\\\"" + joining_month + "\\\"}\"}";
			HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

			// リクエストの送信
			restTemplate.exchange(apiUrl, HttpMethod.POST, requestEntity, String.class);

		} catch (RestClientException e) {
			throw new IOException("Failed to fetch employee data from the API.", e);
		}
	}
}
package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.example.demo.repository.ClockRepository;

@Service
public class ClockService {

	private final ClockRepository clockRepository;

	public ClockService(ClockRepository clockRepository) {
		this.clockRepository = clockRepository;
	}

	public void postClock(int employeeId, String buttonValue) throws IOException, URISyntaxException {

		String clockIn = "";
		String breakStart = "";
		String breakEnd = "";
		String clockOut = "";

		LocalDateTime now = LocalDateTime.now();

		String strNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		if (buttonValue.equals("出勤")) {
			clockIn = strNow;
		} else if (buttonValue.equals("休憩開始")) {
			breakStart = strNow;
		} else if (buttonValue.equals("休憩終了")) {
			breakEnd = strNow;
		} else if (buttonValue.equals("退勤")) {
			clockOut = strNow;
		}

		clockRepository.postClock(employeeId, clockIn, breakStart, breakEnd, clockOut);
	}

}
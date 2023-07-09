package com.example.demo.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.Employee;
import com.example.demo.repository.ShowListEmployeeRepository;
import com.example.demo.utility.Formatter;

@Service
public class ShowListEmployeeService {

	private final ShowListEmployeeRepository repository;

	public ShowListEmployeeService(ShowListEmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> getEmployee(int id) throws IOException, URISyntaxException {

		List<Employee> employees = repository.getEmployee(id);

		for (Employee employee : employees) {

			String date = employee.getJoining_month();

			if (date != null) {

				String yearMonth = Formatter.yearMonthFormat(date, "yyyy-MM-dd", "yyyy/MM");
				employee.setJoining_month(yearMonth);

			}
		}

		return employees;

	}

}
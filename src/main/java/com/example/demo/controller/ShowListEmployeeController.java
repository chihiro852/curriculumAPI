package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.data.Employee;
import com.example.demo.service.ShowListEmployeeService;

@Controller
public class ShowListEmployeeController {

	private final ShowListEmployeeService service;

	public ShowListEmployeeController(ShowListEmployeeService service) {
		this.service = service;
	}

	@GetMapping("showListEmployee")
	public String getEmployees(Model model) throws IOException, URISyntaxException {

		List<Employee> employees = service.getEmployee(0);

		model.addAttribute("employees", employees);

		return "showListEmployee.html";
	}

	@GetMapping("/newEmployee")
	public String newEmployee() {
		return "newEmployee.html";
	}

}
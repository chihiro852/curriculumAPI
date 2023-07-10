package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.data.Employee;
import com.example.demo.service.NewEmployeeService;
import com.example.demo.service.ShowListEmployeeService;

@Controller
public class NewEmployeeController {

	private final NewEmployeeService service;
	private final ShowListEmployeeService showListService;

	public NewEmployeeController(NewEmployeeService service, ShowListEmployeeService showListService) {
		this.service = service;
		this.showListService = showListService;
	}

	@PostMapping("insertEmployee")
	public String doInsert(@RequestParam("name") String name, @RequestParam("hometown") String hometown, @RequestParam("joining_month") String joining_month, Model model) throws IOException, URISyntaxException {

		service.postEmployee(name, hometown, joining_month);

		List<Employee> employees = showListService.getEmployee(0);

		model.addAttribute("employees", employees);

		return "showListEmployee.html";
	}

}
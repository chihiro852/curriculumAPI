package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.data.Clock;
import com.example.demo.data.Employee;
import com.example.demo.service.ShowEmployeeService;
import com.example.demo.service.ShowListEmployeeService;

@Controller
public class ShowEmployeeController {

	private final ShowListEmployeeService listService;
	private final ShowEmployeeService service;

	public ShowEmployeeController(ShowListEmployeeService listService, ShowEmployeeService service) {
		this.listService = listService;
		this.service = service;
	}

	@GetMapping("/showEmployee")
	public String getEmployee(@RequestParam("employeeId") int employeeId, Model model) throws IOException, URISyntaxException {

		List<Employee> employee = listService.getEmployee(employeeId);

		List<Clock> clocks = service.getClock(employeeId);

		model.addAttribute("employee", employee);
		model.addAttribute("clock", clocks);

		return "showEmployee.html";

	}

}
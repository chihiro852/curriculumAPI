package com.example.demo.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.data.Clock;
import com.example.demo.data.Employee;
import com.example.demo.service.ClockService;
import com.example.demo.service.ShowEmployeeService;
import com.example.demo.service.ShowListEmployeeService;

@Controller
public class ClockController {

	private final ClockService service;
	private final ShowListEmployeeService listService;
	private final ShowEmployeeService employeeService;

	public ClockController(ClockService service, ShowListEmployeeService listService, ShowEmployeeService employeeService) {
		this.service = service;
		this.listService = listService;
		this.employeeService = employeeService;
	}

	@PostMapping("clock")
	public String doPost(@RequestParam("employee_id") int employeeId, @RequestParam("button") String buttonValue, Model model) throws IOException, URISyntaxException {

		service.postClock(employeeId, buttonValue);

		List<Employee> employee = listService.getEmployee(employeeId);

		List<Clock> clocks = employeeService.getClock(employeeId);

		model.addAttribute("employee", employee);
		model.addAttribute("clock", clocks);
		return "showEmployee.html";
	}
}
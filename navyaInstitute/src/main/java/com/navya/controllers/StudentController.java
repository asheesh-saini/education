package com.navya.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navya.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studenService;

	@RequestMapping("/students")
	public String studentList(Map map) {
		map.put("students", studenService.getStudents());
		return "students";
	}
}

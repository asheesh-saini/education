package com.navya.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@RequestMapping("/student")
	public String studentById(@ModelAttribute("id") String id,Map map) {
		id = "S1";
		map.put("student", studenService.getStudent(id));
		System.out.println(studenService.getStudent(id).getId());
		return "student";
	}
}

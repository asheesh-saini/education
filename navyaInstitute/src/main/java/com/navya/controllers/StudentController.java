package com.navya.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.navya.entity.StudentEnity;
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
	
	@RequestMapping(value = "/student/add",method=RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("newStudent", new StudentEnity());
		return "newStudent";
	}
	@RequestMapping(value = "/student/add",method=RequestMethod.POST)
	public String addStudent(@ModelAttribute("newStudent") StudentEnity newStudent,Map map) {
		map.put("result", studenService.addStudent(newStudent));
		System.out.println("student id : "+newStudent.getId()); 
		return "redirect:/students";
	}
	@RequestMapping("/student/delete")
	public String removeStudent(@RequestParam("id") String id,Map map) {
		//id = "S3";
		map.put("result", studenService.deleteStudentById(id));
		return "redirect:/students";
	}
}

package com.navya.service;

import java.util.List;

import com.navya.entity.StudentEnity;

public interface StudentService {
	public List<StudentEnity> getStudents();
	public StudentEnity getStudent(String id);
	public String addStudent(StudentEnity student);
	public String deleteStudentById(String id);
}

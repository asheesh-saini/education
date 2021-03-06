package com.navya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navya.entity.StudentEnity;
import com.navya.repoitory.StudentsRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentsRepository studentRepository;

	@Override
	public List<StudentEnity> getStudents() {
		return studentRepository.getAllStudent();
	}

	@Override
	public StudentEnity getStudent(String id) {
		return studentRepository.getStudentById(id);
	}

	@Override
	public String addStudent(StudentEnity student) {
		return studentRepository.addStudent(student);
	}

	@Override
	public String deleteStudentById(String id) {
		// TODO Auto-generated method stub
		return studentRepository.deleteStudent(id);
	}

}

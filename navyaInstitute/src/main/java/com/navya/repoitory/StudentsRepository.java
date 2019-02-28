package com.navya.repoitory;

import java.util.List;

import com.navya.entity.StudentEnity;

public interface StudentsRepository {
	public List<StudentEnity> getAllStudent();
	public StudentEnity getStudentById(String id);
}

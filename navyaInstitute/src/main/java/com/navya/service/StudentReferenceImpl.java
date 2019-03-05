package com.navya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.navya.entity.StudentReference;
import com.navya.repoitory.ReferenceRepository;

public class StudentReferenceImpl implements ReferenceService {
	@Autowired
	private ReferenceRepository reference;

	@Override
	public List<StudentReference> getReferences() {
		return reference.getStudentReferences();
	}
}

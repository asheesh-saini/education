package com.navya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navya.entity.StudentEnity;
import com.navya.entity.StudentReference;
import com.navya.repoitory.ReferenceRepository;

@Service
public class ReferenceServiceImpl implements ReferenceService {
	@Autowired
	private ReferenceRepository reference;

	@Override
	public List<StudentReference> getReferences() {
		return reference.getStudentReferences();
	}

	@Override
	public List<StudentEnity> getStudentsByRefId(String refId) {
		// TODO Auto-generated method stub
		return  reference.getStudentRefList(refId);
	}
}

package com.navya.service;

import java.util.List;

import com.navya.entity.StudentEnity;
import com.navya.entity.StudentReference;

public interface ReferenceService {
	public List<StudentReference> getReferences();
	public List<StudentEnity> getStudentsByRefId(String refId);
}

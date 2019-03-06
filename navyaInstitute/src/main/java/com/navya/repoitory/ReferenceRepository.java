package com.navya.repoitory;

import java.util.List;

import com.navya.entity.StudentEnity;
import com.navya.entity.StudentReference;

public interface ReferenceRepository {
	public List<StudentReference> getStudentReferences();
	public List<StudentEnity> getStudentRefList(String refId);
}

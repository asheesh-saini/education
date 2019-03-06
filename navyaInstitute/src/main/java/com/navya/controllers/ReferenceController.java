package com.navya.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.navya.entity.StudentEnity;
import com.navya.entity.StudentReference;
import com.navya.service.ReferenceService;

@Controller
public class ReferenceController {
	@Autowired
	private ReferenceService refService;

	@RequestMapping(value = "/students/references")
	public String reference(Map map) {
		List<StudentReference> refList = refService.getReferences();
		map.put("references", refList);
		System.out.println("working "+refList);
		return "studentReferences"; 
	}
	
	@RequestMapping(value = "/students/detailsByRef")
	public String studentByRefId(Map map ,@RequestParam("s") String refId) {
		//String refId = "S1";
		System.out.println("ref id :"+refId);
		List<StudentEnity> refList = refService.getStudentsByRefId(refId);
		map.put("references", refList);
		System.out.println("working "+refList);
		return "studentsByRef"; 
	}
}

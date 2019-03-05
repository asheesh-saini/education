package com.navya.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.navya.service.ReferenceService;
import com.navya.service.StudentService;

@Controller
public class ReferenceController {
	@Autowired
	private ReferenceService refService;

	@RequestMapping(value = "/student/references")
	public String reference() {
		refService.getReferences();
		return null;
	}
}

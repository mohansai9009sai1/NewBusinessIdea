package com.business.idea.BusinessIdea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {
	@GetMapping("/getBusinessName")
	public String getName() {
		
		return "SAISAI";
	}

        @GetMapping("/getBusinessidea")
	public String getName() {
		
		return "SAISAISAI";
	}

}

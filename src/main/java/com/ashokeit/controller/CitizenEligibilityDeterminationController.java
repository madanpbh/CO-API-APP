package com.ashokeit.controller;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokeit.dto.CitizenDto;
import com.ashokeit.dto.PlanDto;
import com.ashokeit.service.CitizenEligibilityDeterminationService;

@RestController
public class CitizenEligibilityDeterminationController {
	@Autowired
	private CitizenEligibilityDeterminationService CitizenEligibilityDeterminationServiceImpl;

	@PostMapping(value = "/get-plan-details", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> getPlanDetails(@RequestBody CitizenDto citizenDto)
			throws DroolsParserException, IOException {
		
		PlanDto planDto = null;

		planDto = CitizenEligibilityDeterminationServiceImpl.getPlanDetails(citizenDto);
		
		if (planDto.getPlanStatus().equalsIgnoreCase("Approved")) {
			return ResponseEntity.ok(planDto);
		} else {
			return ResponseEntity.badRequest().body(planDto);
		}

	}
}

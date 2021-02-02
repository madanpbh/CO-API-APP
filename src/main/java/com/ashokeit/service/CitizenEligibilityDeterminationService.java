package com.ashokeit.service;

import java.io.IOException;

import org.drools.compiler.compiler.DroolsParserException;

import com.ashokeit.dto.CitizenDto;
import com.ashokeit.dto.PlanDto;

public interface CitizenEligibilityDeterminationService {
  public PlanDto getPlanDetails(CitizenDto citizen) throws DroolsParserException, IOException;
}

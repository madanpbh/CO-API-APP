package com.ashokeit.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import org.springframework.stereotype.Service;

import com.ashokeit.dto.CitizenDto;
import com.ashokeit.dto.PlanDto;

@Service
public class CitizenEligibilityDeterminationServiceImpl implements CitizenEligibilityDeterminationService {

	@Override

	public PlanDto getPlanDetails(CitizenDto citizen) throws DroolsParserException, IOException {
		PlanDto plan = null;

		plan = new PlanDto();
		plan.setPlanName(citizen.getPlanName());
		plan.setCase_no(citizen.getCaseNo());

		PackageBuilder packageBuilder = new PackageBuilder();

		String ruleFile = "/com/rule/" + citizen.getPlanName() + ".drl";
		System.out.println(ruleFile);
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);

		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();

		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		workingMemory.insert(citizen);
		workingMemory.insert(plan);
		workingMemory.fireAllRules();
		return plan;

	}
}

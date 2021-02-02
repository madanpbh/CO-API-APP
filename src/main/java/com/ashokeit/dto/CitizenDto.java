package com.ashokeit.dto;

import java.util.Date;

import lombok.Data;



@Data
public class CitizenDto {
	protected Integer caseNo;
	protected String firstName;
	protected String lastName;
	protected Date dob;
	protected String gender;
	protected String planName;
	protected Boolean isEmployeed;
	protected Double income;
	protected Integer kidsCount;
	protected Boolean isGraduate;

}

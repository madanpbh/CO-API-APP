package com.ashokeit.dto;

import lombok.Data;

@Data
public class PlanDto {
	protected Integer case_no;
	protected String planName;
	protected String planStatus;
	protected String plantStartDate;
	protected String palnEndDate;
	protected Double benitfitAmt;
	protected String denialReason;	
}

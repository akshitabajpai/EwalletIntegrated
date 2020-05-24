package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.CustomerSupport;





public interface CustomerSupportService {
	
	boolean addIssue(CustomerSupport customersupport);
	List<CustomerSupport> getAllIssue();
	
	CustomerSupport saveIssue(CustomerSupport customersupport);

}
	
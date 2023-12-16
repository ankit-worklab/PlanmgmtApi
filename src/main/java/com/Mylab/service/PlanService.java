package com.Mylab.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Mylab.entities.Plan;
public interface PlanService {
	public Map<Integer,String> getAllCategories();
	public boolean savePlan(Plan plan);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
	public boolean deletePlan(Integer planId);
	public boolean changePlanStatus(Integer planId , String status);
	public boolean updatePlan(Plan plan);
		

}

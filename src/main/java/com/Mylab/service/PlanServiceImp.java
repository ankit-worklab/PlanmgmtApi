package com.Mylab.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mylab.entities.Plan;
import com.Mylab.entities.PlanCategory;
import com.Mylab.repo.PlanCategoryRepo;
import com.Mylab.repo.PlanRepo;
@Service
public class PlanServiceImp implements PlanService {
	@Autowired
	PlanRepo planRepo;
	@Autowired
	PlanCategoryRepo planCategoryRepo;	
	@Override
	public Map<Integer, String> getAllCategories() {
		
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer,String> categoryMap=new HashMap<Integer, String>();
		categories.forEach(category->
		categoryMap.put(category.getCategoryId(),category.getCategoryName())
		);
		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		
		planRepo.save(plan);
		return (plan.getPlanNo()!= 0)?true:false;
		 
	}

	@Override
	public List<Plan> getAllPlans() {
	
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> plan= planRepo.findById(planId);
		if(plan.isPresent()) {
			return plan.get();
		}
		return null;
	}

	@Override
	public boolean deletePlan(Integer planId) {
		Plan plan = getPlanById(planId);
		if(plan != null) {
			planRepo.delete(plan);
			return true;
		}
		return false;
	}

	@Override
	public boolean changePlanStatus(Integer planId, String status) {
		Plan plan = getPlanById(planId);
		if(plan != null) {
			plan.setActiveSwitch(status);
			savePlan(plan);
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		try {
			savePlan(plan);
			return true;
		}catch(Exception e) {
		return false;
		}
	}
	
}

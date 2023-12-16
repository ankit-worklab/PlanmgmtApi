package com.Mylab.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Mylab.Config.AppProperties;
import com.Mylab.constants.AppConstants;
import com.Mylab.entities.Plan;
import com.Mylab.service.PlanService;

@RestController
public class PlanController {
	
	private PlanService planService;
	private Map<String,String> messages;
	
	public PlanController(PlanService planService,AppProperties appProp){
		
		this.planService = planService;
		this.messages= appProp.getMessages();
		System.out.println(this.messages);
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer,String>> fetchAll() {
		
	Map<Integer,String> planCategories =planService.getAllCategories();
	
	ResponseEntity entity = new ResponseEntity<>(planCategories,HttpStatus.OK);
	return entity;	
}
	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		boolean isSaved = planService.savePlan(plan);
		String resp=AppConstants.EMPTY_STR;
		if(isSaved) {
		resp= messages.get(AppConstants.PLAN_SAVE_SUCC);
		}else {
			resp =messages.get(AppConstants.PLAN_SAVE_FAIL);
		}
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("/edit/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) { 
		
		Plan plan = planService.getPlanById(planId);
		
		return new ResponseEntity(plan,HttpStatus.OK);
	}
	
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> getPlanById(@PathVariable Integer planId) {
		
	Plan plan=	planService.getPlanById(planId);
	
	return new ResponseEntity<>(plan , HttpStatus.OK);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans(){
		
		List<Plan> plans = planService.getAllPlans();
		
		return new ResponseEntity<>(plans,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {
		
		boolean isUpdated =planService.updatePlan(plan);
		
		String msg=AppConstants.EMPTY_STR;
		if(isUpdated) {
			msg= messages.get(AppConstants.PLAN_UPDATE_SUCC);
		}else {
			msg=messages.get(AppConstants.PLAN_UPDATE_FAIL);
		
		} return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{planId}")
	public ResponseEntity<String> delectPlan(@PathVariable Integer planId) {
		boolean isDeleted =planService.deletePlan(planId);
		String msg = AppConstants.EMPTY_STR;
		if(isDeleted) {
			msg= messages.get(AppConstants.PLAN_DELETE_SUCC);
		}
		else {
			msg= messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PutMapping("/changeStatus/{planId}/{status}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer planId,@PathVariable String status) {
		boolean isChanged=planService.changePlanStatus(planId, status);
		String msg=AppConstants.EMPTY_STR;
		if(isChanged) {
			msg=messages.get(AppConstants.CHANGE_STATUS_SUCC);
		}else {
			msg=messages.get(AppConstants.CHANGE_STATUS_FAIL);
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}

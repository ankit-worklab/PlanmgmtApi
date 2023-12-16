package com.Mylab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mylab.entities.Plan;

public interface PlanRepo extends JpaRepository<Plan,Integer> {

}

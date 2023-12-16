package com.Mylab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mylab.entities.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}

package com.Mylab.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="PLAN")
@Data
public class Plan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLAN_NO")
	private int planNo;
	@Column(name="PLAN_NM")
	private String planName;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@Column(name="END_DATE")
	private LocalDate endDate;
	@Column(name="ACTIVE")
	private String activeSwitch;
	@Column(name="CATEGORY_ID")
	private int categoryId;
	@Column(name="created_dt")
	private LocalDate createdDate;
	@Column(name="updated_dt")
	private LocalDate updatedDate;
	@Column(name="created_By")
	private String createdBy;
	@Column(name="updated_By")
	private String updatedBy;
	
}

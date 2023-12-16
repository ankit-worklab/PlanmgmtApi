package com.Mylab.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter
@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	@Column(name="CATEGOGY_NAME")
	private String categoryName;
	@Column(name="ACTIVE")
	private String activeSwitch;
	@Column(name="created_dt")
	private LocalDate createdDate;
	@Column(name="updated_dt")
	private LocalDate updatedDate;
	@Column(name="created_By")
	private String createdBy;
	@Column(name="updated_By")
	private String updatedBy;
	

}

package com.zavada.domain;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

import com.zavada.entity.User;
import com.zavada.entity.enumeration.Category;
import com.zavada.validator.CheckIfCourseTitleExists;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CourseRequest {
	
	@CheckIfCourseTitleExists
	@Size(min = 5, max = 150)
	private String title;	
	
	@Size(min = 10, max = 500)
	private String description;
	private String courseImage;
	
	@DecimalMin(value = "9.00", inclusive = true)
	@DecimalMax(value = "299.99", inclusive = true)
	private BigDecimal price;
	
	private User user;
	private Category category;
}

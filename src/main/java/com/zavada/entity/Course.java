package com.zavada.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.zavada.entity.enumeration.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "course", indexes = @Index(columnList = "title"))
@NoArgsConstructor
@Getter @Setter
public class Course extends BaseEntity {


	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column(name = "course_image")
	private String courseImage;
	
	@Column(columnDefinition = "DECIMAL(5,2)")
	private BigDecimal price;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
}

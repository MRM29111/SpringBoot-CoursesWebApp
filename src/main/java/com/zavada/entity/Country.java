package com.zavada.entity;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "country", indexes = @Index(columnList = "name"))
@NoArgsConstructor
@Getter @Setter
public class Country extends BaseEntity {


	private String name;
	
	private String shortName;
	
	
	
}

package com.zavada.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter @Setter
public class User extends BaseEntity {

	private static final long serialVersionUID = -3796473817665214908L;

	private String email;
	private String password;
	
	@Column(name = "user_image")
	private String userImage;
	
	private String fullName;
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
}

package com.zavada.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	@Column(name = "user_image_path")
	private String userImagePath;
	
	
}

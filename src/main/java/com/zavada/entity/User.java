package com.zavada.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.zavada.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter @Setter
public class User extends BaseEntity {


	private String email;
	private String password;
	
	@Column(name = "user_image")
	private String userImage;
	
	private String fullName;
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;
	
	@OneToMany(mappedBy = "user")
	private Set<Course> courses;
	
	@Enumerated(EnumType.ORDINAL)
	private Role role;
	
	@Column(name = "is_edited", columnDefinition = "BOOLEAN DEFAULT FALSE")
	private boolean isEdited;
}

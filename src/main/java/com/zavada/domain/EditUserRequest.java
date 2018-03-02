package com.zavada.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.zavada.entity.Country;
import com.zavada.entity.enumeration.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditUserRequest {

	private int id;
	private String email;
	private String password;
	
	@Size(min = 5, max = 25)
	private String fullName;
	
	@Min(value = 18)
	@Max(value = 65)
	private int age;
	
	private MultipartFile profileImage;
	private Country country;
	private Role role;
	// private String userImagePath;
}

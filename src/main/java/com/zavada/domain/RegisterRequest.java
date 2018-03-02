package com.zavada.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.zavada.entity.enumeration.Role;
import com.zavada.validator.CheckIfEmailExists;
import com.zavada.validator.CheckPasswordsMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckPasswordsMatch
public class RegisterRequest {
	
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Typed email has not correct format")
	@CheckIfEmailExists
	@NotEmpty private String email;
	@NotEmpty private String password;
	@NotEmpty private String passwordConfirm;
	@NotNull private Role role;
}

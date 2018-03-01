package com.zavada.domain;

import com.zavada.validator.CheckEmailPasswordCombination;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@CheckEmailPasswordCombination
public class LoginRequest {

	private String email;
	private String password;
	
}

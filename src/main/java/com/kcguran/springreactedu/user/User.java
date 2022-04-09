package com.kcguran.springreactedu.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message = "{kcguran.constraint.username.NotNull.message}")
	@Size(min = 4,max = 20)
	@UniqueUsername
	private String username;
	@NotNull
	@Size(min = 4,max = 20)
	private String displayName;
	@NotNull
	@Size(min = 8)
	@Pattern(regexp = "^(_=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{kcguran.constrain.password.Pattern.message}")
	private String password;
}

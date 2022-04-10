package com.kcguran.springreactedu.user;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.text.View;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.kcguran.springreactedu.shared.Views;
import com.kcguran.springreactedu.shared.Views.Sensitive;

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
	@JsonView(Views.Base.class)
	private String username;
	@NotNull
	@Size(min = 4,max = 20)
	@JsonView(Views.Base.class)
	private String displayName;
	@NotNull
	@Size(min = 8)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{kcguran.constrain.password.Pattern.message}")
	@JsonView(Views.Sensitive.class)
	private String password;
	
	@JsonView(Views.Base.class)
	private String image;
}

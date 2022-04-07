package com.kcguran.springreactedu.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;
	private String username;
	private String displayName;
	private String password;
}

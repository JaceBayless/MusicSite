package com.musicsite.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Data
public class UserRole implements GrantedAuthority {
	
	private static final long serialVersionUID = -1606445429739641471L;
	
	@Id
	private String authority;

}

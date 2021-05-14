package com.modules.sirsr.main.domain;

import java.io.Serializable;
import java.util.Objects;

public class LoginDTO implements Serializable {
	private String userName;
	private String email;
	private String password;
	private String password2;

	public LoginDTO() {
	}

	public String getUserName() {
		return userName = Objects.nonNull(userName) ? userName.toUpperCase() : userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password = Objects.nonNull(password) ? password.toUpperCase() : password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2 = Objects.nonNull(password2) ? password2.toUpperCase() : password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
}
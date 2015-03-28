package com.geminisystems.portlet.entity;


/**
 * Author: Georgy Gobozov
 * Date: 09.04.13
 */
public class User {

    private Long userId;
    private String login;
    private String password;
    private String email;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	@Override
	public String toString(){
		return login + " " + password + " " + email;
	}
	
}

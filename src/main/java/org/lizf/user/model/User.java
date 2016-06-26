package org.lizf.user.model;

import java.util.Date;

public class User {

	private String id;
	private String username;
	private String password;
	private Date lastLoginTime;
	private String lastLoginIp;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("----------User.toString start---------\n");
		sb.append("id : ").append(id).append("\n");
		sb.append("username : ").append(username).append("\n");
		sb.append("password : ").append("******").append("\n");
		sb.append("lastLoginTime : ").append(lastLoginTime).append("\n");
		sb.append("lastLoginIp : ").append(lastLoginIp).append("\n");
		sb.append("----------User.toString end-----------\n");
		return sb.toString();
	}

}

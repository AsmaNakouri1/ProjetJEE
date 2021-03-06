package entity;

// Generated 9 d�c. 2015 14:27:09 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur implements java.io.Serializable {

	private String login;
	private String password;

	public Utilisateur() {
	}

	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Id
	@Column(name = "LOGIN", unique = true, nullable = false, length = 4000)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD", nullable = false, length = 4000)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

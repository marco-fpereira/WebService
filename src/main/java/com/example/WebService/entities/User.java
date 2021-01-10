package com.example.WebService.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity //usado para identificar que a classe a seguir eh uma entidade que correspondera a uma tabela
@Table(name = "tb_user")	// just renaming the table that refers to this class in the database
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id //indicando que o atributo a seguir sera o atributo chave da tabela
	@GeneratedValue(strategy=GenerationType.IDENTITY) //indicando que o id sera de autoincremento
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

	@JsonIgnore // this annotation will prevent the existence of a loop caused by the two-way association between User and Order
	//this annotation defines that this class has one to many relationship with the Order class, and which attribute is associated to this class
	@OneToMany(mappedBy = "client") 
	private List<Order> orders = new ArrayList<>();
	
	public User () {}

	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrders() {
		return orders;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

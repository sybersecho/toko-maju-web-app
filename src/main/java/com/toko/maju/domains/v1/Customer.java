package com.toko.maju.domains.v1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String address;
	private String phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.EAGER)
	private Set<Project> projects = new HashSet<Project>();

	@Builder
	public Customer(Long id, String code, String name, String address, String phoneNumber, Set<Project> projects) {
		super(id);
		this.code = code;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.projects = projects;
	}

}

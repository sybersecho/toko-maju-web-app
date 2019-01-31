package com.toko.maju.domains.v1;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String address;

	@ManyToOne
	private Customer customer;

	@Builder
	public Project(Long id, String name, String address, Customer customer) {
		super(id);
		this.name = name;
		this.address = address;
		this.customer = customer;
	}

}

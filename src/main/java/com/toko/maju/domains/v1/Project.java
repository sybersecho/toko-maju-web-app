package com.toko.maju.domains.v1;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
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

//	@JsonIgnore()
//	@JsonProperty(access = Access.READ_ONLY)
//	@JsonBackReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private Set<ProjectProduct> products = new HashSet<ProjectProduct>();

	@Builder
	public Project(Long id, String name, String address, Customer customer) {
		super(id);
		this.name = name;
		this.address = address;
		this.customer = customer;
	}

}

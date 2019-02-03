package com.toko.maju.domains.v1;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@Entity
@Table(name = "project_product")
public class ProjectProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@Id
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	@Id
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private BigDecimal productPrice;

	public ProjectProduct(Project project, Product product, BigDecimal productPrice) {
		this.project = project;
		this.product = product;
		this.productPrice = productPrice;
	}

}

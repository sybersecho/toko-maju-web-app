package com.toko.maju.domains.v1;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "product")
public class Product extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String barcode;
	private String name;
	private String unit;
	private BigDecimal warehousePrices;
	private BigDecimal unitPrices;
	private BigDecimal sellingPrices;
	private Integer stock;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Supplier supplier;

////	@JsonIgnore
//	@OneToMany(mappedBy = "project")
//	private Set<ProjectProduct> projects = new HashSet<ProjectProduct>();

	@Builder
	public Product(Long id, String barcode, String name, String unit, BigDecimal warehousePrices, BigDecimal unitPrices,
			BigDecimal sellingPrices, Integer stock) {
		super(id);
		this.barcode = barcode;
		this.name = name;
		this.unit = unit;
		this.warehousePrices = warehousePrices;
		this.unitPrices = unitPrices;
		this.sellingPrices = sellingPrices;
		this.stock = stock;
	}

}

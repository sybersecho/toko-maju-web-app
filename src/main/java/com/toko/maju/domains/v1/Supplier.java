package com.toko.maju.domains.v1;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class Supplier extends BaseEntity {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String name;
	private String code;
	private String address;
	private String phoneNumber;
	private String bankAccount;
	private String bankName;

	@Builder
	public Supplier(Long id, String name, String code, String address, String phoneNumber, String bankAccount,
			String bankName) {
		super(id);
		this.name = name;
		this.code = code;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.bankAccount = bankAccount;
		this.bankName = bankName;
	}

}

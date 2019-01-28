package com.toko.maju.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
	private Long id;
	private String name;
	private String address;
	private CustomerDTO customer;
}

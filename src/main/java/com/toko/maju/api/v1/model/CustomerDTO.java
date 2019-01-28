package com.toko.maju.api.v1.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
	private Long id;
	private String code;
	private String name;
	private String address;
	private String phoneNumber;
	private Set<ProjectDTO> projects;
}

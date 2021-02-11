package com.webflux.client.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDomainModel {
	
	private Long id;
	
	private String name;
	
	private String field;

}

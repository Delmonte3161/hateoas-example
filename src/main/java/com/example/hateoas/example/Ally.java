package com.example.hateoas.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ds3161
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Ally extends Person {
	private String freedom;

	/**
	 * @param id
	 * @param first
	 * @param last
	 * @param address
	 * @param freedom
	 */
	public Ally(Long id, String first, String last, String address, String freedom) {
		super(id, first, last, address);
		this.freedom = freedom;
	}

}

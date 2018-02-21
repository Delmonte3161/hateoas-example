package com.example.hateoas.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author ds3161
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Axis extends Person {
	private String evil;

	/**
	 * @param id
	 * @param first
	 * @param last
	 * @param address
	 * @param evil
	 */
	public Axis(Long id, String first, String last, String address, String evil) {
		super(id, first, last, address);
		this.evil = evil;
	}
}

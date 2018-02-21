package com.example.hateoas.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ds3161
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	protected Long id;
	protected String first;
	protected String last;
	protected String address;
}

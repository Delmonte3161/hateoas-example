package com.example.hateoas.example;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * @author ds3161
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ExampleController {
	private final DummyService service;

	/**
	 * @return ResponseEntity<Resources<Resource<Person>>>
	 */
	@GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resources<Resource<?>>> getPersons() {
		Collection<Person> persons = service.getPersons();
		List<Resource<?>> personResources = new ArrayList<>();
		for (Person person : persons) {
			personResources.add(getPersonResource(person));
		}
		Link selfLink = linkTo(ExampleController.class).slash("/person").withSelfRel();

		// Wrap your resources in a Resources object.
		Resources<Resource<?>> resourceList = new Resources<Resource<?>>(personResources,
				selfLink);

		return new ResponseEntity<Resources<Resource<?>>>(resourceList, HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return ResponseEntity<Resource<Person>>
	 */
	@GetMapping(value = "/person/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Resource<Person>> getPerson(@PathVariable Long id) {
		Person person = service.getPerson(id);
		return new ResponseEntity<Resource<Person>>(getPersonResource(person),
				HttpStatus.OK);
	}

	private Resource<Person> getPersonResource(Person person) {
		// Provide a link to lookup book. Method not provided in this example.
		Link selfLink = linkTo(ExampleController.class).slash("/person")
				.slash(person.getId()).withSelfRel();
		return new Resource<Person>(person, selfLink.expand(person.getId()));
	}
}

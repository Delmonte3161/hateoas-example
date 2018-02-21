package com.example.hateoas.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author ds3161
 *
 */
@Service
public class DummyService {

	Map<Long, Person> persons = new HashMap<>();

	/**
	 * 
	 */
	public DummyService() {
		persons = createPersonList();
	}

	private Map<Long, Person> createPersonList() {
		Map<Long, Person> returnMap = new HashMap<>();
		Person person = new Ally(1L, "Joseph", "Stalin", "666 Communist Lane",
				"Marginal");
		returnMap.put(person.getId(), person);
		person = new Ally(2L, "Winston", "Churchill", "123 Cigar Blvd", "So I hear");
		returnMap.put(person.getId(), person);
		person = new Ally(3L, "Franklin", "Roosevelt", "4 Term Road",
				"Confined to wheelchair");
		returnMap.put(person.getId(), person);
		person = new Axis(4L, "Adolf", "Hitler", "42 Mein Kampf St", "Historically high");
		returnMap.put(person.getId(), person);
		person = new Axis(5L, "Benito", "Mussolini", "777 Fascist Ave",
				"Major jerk face");
		returnMap.put(person.getId(), person);
		person = new Axis(6L, "Hideki", "Tojo", "321 Kamikaze Circle", "Octopus");
		returnMap.put(person.getId(), person);
		return returnMap;
	}

	/**
	 * @return Collection
	 */
	public Collection<Person> getPersons() {
		return persons.values();
	}

	/**
	 * @param id
	 * @return Person
	 */
	public Person getPerson(Long id) {
		if (persons.containsKey(id))
			return persons.get(id);
		return null;
	}
}

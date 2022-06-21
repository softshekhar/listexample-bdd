package no.example.assessment.stream.factory;

import no.example.assessment.stream.model.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MockPersonFactory implements PersonFactory {
	@Override public List<Person> getAllPersons() {
		return Arrays
				.asList(new Person("Huey", "Duck", LocalDate.of(getYearOfBirth(14), 12, 12), Person.Sex.MALE),
						new Person("Scrooge", "McDuck", LocalDate.of(getYearOfBirth(42), 11, 1), Person.Sex.MALE),
						new Person("Louie", "Duck", LocalDate.of(getYearOfBirth(15), 10, 12), Person.Sex.MALE),
						new Person("Dewey", "Duck", LocalDate.of(getYearOfBirth(16), 9, 5), Person.Sex.MALE),
						new Person("Donald", "Duck", LocalDate.of(getYearOfBirth(22), 2, 2), Person.Sex.MALE),
						new Person("Daisy", "Duck", LocalDate.of(getYearOfBirth(19), 4, 2), Person.Sex.FEMALE),
						new Person("Gus", "Goose", LocalDate.of(getYearOfBirth(22), 7, 5), Person.Sex.MALE));

	}


	private int getYearOfBirth(int age) {
		return LocalDate.now().getYear() - age;
	}
}

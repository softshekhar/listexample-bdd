package no.example.assessment.stream.service;

import no.example.assessment.stream.factory.MockPersonFactory;
import no.example.assessment.stream.model.Person;
import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PersonServiceTest {

	private PersonService personService;

	@Before public void before() throws Throwable {
		MockPersonFactory mockPersonFactory = new MockPersonFactory();
		personService = new PersonService(mockPersonFactory.getAllPersons());

	}

	@Test public void lastNameTest() {
		System.out.println("Printing persons with surname Duck");
		List<Person> listOfDucks = personService.getPeopleWithLastName("Duck");
		BDDAssertions.then(listOfDucks.size()).isEqualTo(5);

		printInfo(listOfDucks);
	}

	@Test public void adultsTest() {
		System.out.println("Printing all Adults");
		List<Person> listOfAdults = personService.getAdults();
		BDDAssertions.then(listOfAdults.size()).isEqualTo(4);

		printInfo(listOfAdults);
	}

	@Test public void sortingTest() {
		System.out.println("Printing after sorting by age");
		List<Person> sortedByAge = personService.getSortedByAge();
		printInfo(sortedByAge);
	}

	@Test public void agerageAdultAgeTest() {
		System.out.println("Printing average age of adults");
		float averageAgeOfAdults = personService.getAverageAgeOfAllAdults();
		System.out.println("Average age of adults : " + averageAgeOfAdults);
		BDDAssertions.then(averageAgeOfAdults).isGreaterThanOrEqualTo(18.0f);
	}

	private void printInfo(List<Person> people) {
		people.forEach(System.out::println);
		System.out.println("-----------------------------------------------------------");

	}

}

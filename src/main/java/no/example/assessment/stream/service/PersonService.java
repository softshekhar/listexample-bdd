package no.example.assessment.stream.service;

import no.example.assessment.stream.model.Person;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {

    private final List<Person> people;

    public PersonService(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeopleWithLastName(String lastName) {
        return this.people.stream().filter(person -> person.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    public List<Person> getAdults() {
        return this.people.stream().filter(person -> person.isAdult()).collect(Collectors.toList());
    }

    public List<Person> getSortedByAge() {

        return this.people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()
                .thenComparing(Person::getName)).collect(Collectors.toList());

    }

    public float getAverageAgeOfAllAdults() {
        int totalAge = getAdults().stream().map(adult -> adult.getAge()).reduce(0, (subtotal, element) -> subtotal + element);
        return Integer.valueOf(totalAge).floatValue() / getAdults().size();
    }

}

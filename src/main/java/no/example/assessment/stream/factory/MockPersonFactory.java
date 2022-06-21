package no.example.assessment.stream.factory;

import no.example.assessment.stream.model.Person;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MockPersonFactory implements PersonFactory {
    @Override
    public List<Person> getAllPersons() {
        return Arrays
                .asList(
                        new Person.PersonBuilder().firstName("Huey").lastName("Duck").birthday(LocalDate.of(getYearOfBirth(14), 12, 12)).gender(Person.Sex.MALE).build(),
                        new Person.PersonBuilder().firstName("Scrooge").lastName("McDuck").birthday(LocalDate.of(getYearOfBirth(42), 11, 1)).gender(Person.Sex.MALE).income(348_000.0d).build(),
                        new Person.PersonBuilder().firstName("Louie").lastName("Duck").birthday(LocalDate.of(getYearOfBirth(15), 10, 12)).gender(Person.Sex.MALE).build(),
                        new Person.PersonBuilder().firstName("Dewey").lastName("Duck").birthday(LocalDate.of(getYearOfBirth(16), 9, 5)).gender(Person.Sex.MALE).build(),
                        new Person.PersonBuilder().firstName("Donald").lastName("Duck").birthday(LocalDate.of(getYearOfBirth(22), 2, 2)).gender(Person.Sex.MALE).income(148_000.0d).build(),
                        new Person.PersonBuilder().firstName("Daisy").lastName("Duck").birthday(LocalDate.of(getYearOfBirth(19), 4, 2)).gender(Person.Sex.FEMALE).income(48_000.0d).build(),
                        new Person.PersonBuilder().firstName("Gus").lastName("Goose").birthday(LocalDate.of(getYearOfBirth(22), 7, 5)).gender(Person.Sex.MALE).income(1_748_000.0d).build());
    }


    private int getYearOfBirth(int age) {
        return LocalDate.now().getYear() - age;
    }
}

package no.example.assessment.stream.model;

import no.example.assessment.stream.constants.TaxSlab;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Sex gender;
    private final double income;

    public Person(PersonBuilder personBuilder) {
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
        this.birthday = personBuilder.birthday;
        this.gender = personBuilder.gender;
        this.income = personBuilder.income;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public double getIncome() {
        return income;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        return period.getYears();
    }

    public double calculateTaxableAmount() {
        Optional<TaxSlab> applicableTaxSlab = Arrays.stream(TaxSlab.values()).sorted(Comparator.comparingDouble(TaxSlab::incomeCeiling).reversed()).filter(it -> this.income >= it.incomeCeiling()).findFirst();
        if (applicableTaxSlab.isPresent()) {
            return applicableTaxSlab.get().taxPercentage() * this.income * 0.01;
        } else {
            return 0.0d;
        }
    }

    public double calculateTaxPercentage() {
        Optional<TaxSlab> applicableTaxSlab = Arrays.stream(TaxSlab.values()).sorted(Comparator.comparingDouble(TaxSlab::incomeCeiling).reversed()).filter(it -> this.income >= it.incomeCeiling()).findFirst();
        if (applicableTaxSlab.isPresent()) {
            return applicableTaxSlab.get().taxPercentage();
        } else {
            return 0.0d;
        }
    }

    public boolean isAdult() {
        return getAge() >= 18;
    }

    @Override
    public boolean equals(Object anotherObject) {
        if (this == anotherObject) {
            return true;
        }

        if (anotherObject == null || this.getClass() != anotherObject.getClass()) {
            return false;
        }

        Person anotherPerson = (Person) anotherObject;

        return Objects.equals(this.firstName, anotherPerson.getFirstName()) && Objects
                .equals(this.lastName, anotherPerson.getLastName()) && Objects
                .equals(this.gender, anotherPerson.getGender()) && Objects
                .equals(this.birthday, anotherPerson.getBirthday());

    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " Age: " + this.getAge() + " Income: " + this.income + " Tax to pay: " + this.calculateTaxableAmount() + " Taxable percentage: " + this.calculateTaxPercentage();
    }

    public enum Sex {
        MALE, FEMALE
    }

    public static class PersonBuilder {
        private String firstName;
        private String lastName;
        private LocalDate birthday;
        private Sex gender;

        private double income;

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder birthday(LocalDate birthday) {
            this.birthday = birthday;
            return this;
        }

        public PersonBuilder gender(Sex gender) {
            this.gender = gender;
            return this;
        }

        public PersonBuilder income(double income) {
            this.income = income;
            return this;
        }

        //Return the finally consrcuted Person object
        public Person build() {
            return new Person(this);
        }
    }
}

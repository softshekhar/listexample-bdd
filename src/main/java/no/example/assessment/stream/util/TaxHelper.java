package no.example.assessment.stream.util;

import no.example.assessment.stream.constants.TaxSlab;
import no.example.assessment.stream.model.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

public class TaxHelper {

    public static double calculateTaxableAmount(Person person) {
        Optional<TaxSlab> applicableTaxSlab = Arrays.stream(TaxSlab.values()).sorted(Comparator.comparingDouble(TaxSlab::incomeCeiling).reversed()).filter(it -> person.getIncome() >= it.incomeCeiling()).findFirst();
        if (applicableTaxSlab.isPresent()) {
            return applicableTaxSlab.get().taxPercentage() * person.getIncome() * 0.01;
        } else {
            return 0.0d;
        }
    }

    public static double calculateTaxPercentage(Person person) {
        Optional<TaxSlab> applicableTaxSlab = Arrays.stream(TaxSlab.values()).sorted(Comparator.comparingDouble(TaxSlab::incomeCeiling).reversed()).filter(it -> person.getIncome() >= it.incomeCeiling()).findFirst();
        if (applicableTaxSlab.isPresent()) {
            return applicableTaxSlab.get().taxPercentage();
        } else {
            return 0.0d;
        }
    }
}

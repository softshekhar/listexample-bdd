package no.example.assessment.stream.constants;

public enum TaxSlab {

    A(50_000.0d, 0.0d),
    B(100_000.0d, 10.0d),
    C(200_000.0d, 15.0d),
    D(500_000.0d, 20.0d),
    E(1_000_000.0d, 25.0d);

    private final double incomeCeiling;
    private final double taxPercentage;

    TaxSlab(double incomeCeiling, double taxPercentage) {
        this.incomeCeiling = incomeCeiling;
        this.taxPercentage = taxPercentage;
    }

    public double incomeCeiling() {
        return incomeCeiling;
    }

    public double taxPercentage() {
        return taxPercentage;
    }

}

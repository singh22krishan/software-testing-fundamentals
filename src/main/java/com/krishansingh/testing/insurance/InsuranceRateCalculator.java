package com.krishansingh.testing.insurance;

/** Applies the decision-table rules used in the black-box testing exercise. */
public final class InsuranceRateCalculator {
    private InsuranceRateCalculator() {
    }

    public static double quote(
            double baseRate,
            int age,
            boolean male,
            boolean goodDrivingRecord,
            boolean businessUse) {
        if (baseRate < 0 || age < 0) {
            throw new IllegalArgumentException("Base rate and age must be non-negative");
        }

        double rate = baseRate;
        if (age > 55 && goodDrivingRecord) {
            rate *= 0.90;
        } else if (male && age < 25) {
            rate *= 1.50;
        }

        if (businessUse) {
            rate *= 1.20;
        }
        return rate;
    }
}

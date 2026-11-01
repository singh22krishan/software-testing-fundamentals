package com.krishansingh.testing.insurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class InsuranceRateCalculatorTest {
    private static final double BASE = 1_000.00;

    @Test
    void seniorGoodDriverPersonalUseGetsTenPercentReduction() {
        assertEquals(900.00, InsuranceRateCalculator.quote(BASE, 65, false, true, false), 0.001);
    }

    @Test
    void seniorGoodDriverBusinessUseCombinesApplicableRules() {
        assertEquals(1_080.00, InsuranceRateCalculator.quote(BASE, 65, false, true, true), 0.001);
    }

    @Test
    void youngMalePersonalUseGetsFiftyPercentIncrease() {
        assertEquals(1_500.00, InsuranceRateCalculator.quote(BASE, 23, true, false, false), 0.001);
    }

    @Test
    void youngMaleBusinessUseGetsBothIncreases() {
        assertEquals(1_800.00, InsuranceRateCalculator.quote(BASE, 23, true, false, true), 0.001);
    }

    @Test
    void businessUseOnlyAddsTwentyPercent() {
        assertEquals(1_200.00, InsuranceRateCalculator.quote(BASE, 40, false, false, true), 0.001);
    }

    @Test
    void noSpecialConditionReturnsBaseRate() {
        assertEquals(BASE, InsuranceRateCalculator.quote(BASE, 40, false, false, false), 0.001);
    }
}

package com.krishansingh.testing.banking;

import static com.krishansingh.testing.banking.PaymentOutcome.FundingSource.CHECKING;
import static com.krishansingh.testing.banking.PaymentOutcome.FundingSource.NONE;
import static com.krishansingh.testing.banking.PaymentOutcome.FundingSource.OVERDRAFT;
import static com.krishansingh.testing.banking.PaymentOutcome.FundingSource.SAVINGS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BillPaymentServiceTest {
    @Test
    void paysFromCheckingWhenBalanceCoversBill() {
        PaymentOutcome result = BillPaymentService.pay(500, 100, 200, false, 0);
        assertTrue(result.paid());
        assertEquals(300, result.checkingBalance(), 0.001);
        assertEquals(0, result.serviceFee(), 0.001);
        assertEquals(CHECKING, result.fundingSource());
    }

    @Test
    void overdraftHasPriorityOverSavingsWhenItCoversShortfall() {
        PaymentOutcome result = BillPaymentService.pay(100, 1_000, 250, true, 200);
        assertTrue(result.paid());
        assertEquals(-155, result.checkingBalance(), 0.001);
        assertEquals(5, result.serviceFee(), 0.001);
        assertEquals(OVERDRAFT, result.fundingSource());
    }

    @Test
    void transfersShortfallFromSavingsWhenNoApplicableOverdraft() {
        PaymentOutcome result = BillPaymentService.pay(100, 500, 250, false, 0);
        assertTrue(result.paid());
        assertEquals(0, result.checkingBalance(), 0.001);
        assertEquals(350, result.savingsBalance(), 0.001);
        assertEquals(SAVINGS, result.fundingSource());
    }

    @Test
    void declinesPaymentAndChargesFeeWhenNoFundingSourceCoversBill() {
        PaymentOutcome result = BillPaymentService.pay(4, 0, 10, false, 0);
        assertFalse(result.paid());
        assertEquals(-1, result.checkingBalance(), 0.001);
        assertEquals(5, result.serviceFee(), 0.001);
        assertTrue(result.notificationSent());
        assertEquals(NONE, result.fundingSource());
    }
}

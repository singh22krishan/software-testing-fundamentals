package com.krishansingh.testing.banking;

public record PaymentOutcome(
        boolean paid,
        double checkingBalance,
        double savingsBalance,
        double serviceFee,
        boolean notificationSent,
        FundingSource fundingSource) {

    public enum FundingSource {
        CHECKING,
        OVERDRAFT,
        SAVINGS,
        NONE
    }
}

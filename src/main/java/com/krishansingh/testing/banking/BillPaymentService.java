package com.krishansingh.testing.banking;

import com.krishansingh.testing.banking.PaymentOutcome.FundingSource;

/** Implements the ordered bill-payment decision table from the black-box testing exercise. */
public final class BillPaymentService {
    private static final double SERVICE_FEE = 5.00;

    private BillPaymentService() {
    }

    public static PaymentOutcome pay(
            double checkingBalance,
            double savingsBalance,
            double billAmount,
            boolean overdraftProtection,
            double overdraftLimit) {
        if (billAmount <= 0 || savingsBalance < 0 || overdraftLimit < 0) {
            throw new IllegalArgumentException("Amounts must satisfy the account rules");
        }

        if (checkingBalance >= billAmount) {
            return new PaymentOutcome(
                    true,
                    checkingBalance - billAmount,
                    savingsBalance,
                    0,
                    false,
                    FundingSource.CHECKING);
        }

        double shortfall = billAmount - checkingBalance;
        if (overdraftProtection && overdraftLimit >= shortfall) {
            return new PaymentOutcome(
                    true,
                    checkingBalance - billAmount - SERVICE_FEE,
                    savingsBalance,
                    SERVICE_FEE,
                    false,
                    FundingSource.OVERDRAFT);
        }

        if (savingsBalance >= shortfall) {
            return new PaymentOutcome(
                    true,
                    0,
                    savingsBalance - shortfall,
                    0,
                    false,
                    FundingSource.SAVINGS);
        }

        return new PaymentOutcome(
                false,
                checkingBalance - SERVICE_FEE,
                savingsBalance,
                SERVICE_FEE,
                true,
                FundingSource.NONE);
    }
}

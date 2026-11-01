# Debugging and TDD Notes

## Debugging exercise

The original coursework used an airline-ticket prototype and Eclipse debugging tools. The defect-analysis work identified issues such as:

- an employee discount being applied to business-class tickets when the rule only allowed the discount for economy tickets;
- a sold ticket not being assigned back to its seat, causing the manifest to display sold seats as available;
- a sold-seat counter not being updated, allowing the purchase loop to continue after all seats were sold.

The exercise used breakpoints plus Step In, Step Over, and Step Out to trace state changes and locate the failing logic. The original application source is intentionally not republished in this portfolio repository.

## Test-Driven Development

The coursework used the Red–Green–Refactor cycle:

1. **Red:** write a test that initially fails.
2. **Green:** implement only enough production code to make the test pass.
3. **Refactor:** improve the design while keeping the suite green.

A key takeaway from the coursework was that TDD is useful but should not be treated as the complete testing strategy. Passing unit tests does not automatically cover performance, reliability, usability, exploratory risk, or all edge conditions. TDD works best alongside other verification techniques.

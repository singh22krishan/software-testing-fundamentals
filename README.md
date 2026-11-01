# Software Testing Fundamentals

[![Java Tests](https://github.com/singh22krishan/software-testing-fundamentals/actions/workflows/tests.yml/badge.svg)](https://github.com/singh22krishan/software-testing-fundamentals/actions/workflows/tests.yml)

A clean Java testing portfolio project demonstrating **JUnit 5, black-box test design, equivalence partitioning, boundary value analysis, decision-table testing, negative testing, debugging concepts, TDD, and static analysis**.

## Portfolio Context

This repository is a standalone portfolio reconstruction based on testing work completed in **COMP311 Software Testing**. The original coursework included instructor-provided application code, assignment documents, Eclipse workspace files, and student identifiers. Those materials are intentionally not republished here.

Instead, the repository preserves the testing techniques and recreates small self-contained Java examples so the test design can be reviewed and executed independently.

## What This Demonstrates

- JUnit 5 unit and parameterized tests
- Positive and negative test cases
- `assertThrows`-style invalid-input testing
- Equivalence partitioning
- Boundary value analysis
- Decision-table / business-rule testing
- Behavior-focused test naming
- TDD Red–Green–Refactor concepts
- Debugging and defect-analysis concepts
- Checkstyle static analysis
- GitHub Actions CI

## Examples

### Grade classification

Boundary-focused tests exercise the valid partitions from **F through A+**, plus invalid values below 0 and above 100.

### Insurance quotation

Tests cover combinations from a decision table, including senior/good-driver reductions, young-male risk factors, business-use adjustments, and baseline pricing.

### Online bill payment

Tests verify ordered business rules for checking balance, overdraft protection, savings transfer, service fees, notifications, and declined payments.

## Project Structure

```text
src/main/java/              small production examples
src/test/java/              JUnit test suites
config/checkstyle.xml       static-analysis rules
docs/TEST-DESIGN.md         black-box technique notes
docs/DEBUGGING-AND-TDD.md   debugging and TDD notes
.github/workflows/tests.yml CI pipeline
```

## Run Locally

Requirements: Java 17+ and Maven 3.9+.

```bash
mvn clean verify
```

This runs the JUnit suite and Checkstyle verification.

## Why This Repo Exists Alongside Selenium Automation

`selenium-java-test-automation` demonstrates browser automation and framework structure. This repository focuses on the **test-analysis and test-design fundamentals underneath automation**: selecting representative inputs, testing boundaries, translating business rules into test conditions, negative testing, and documenting defects.

## Academic Context

The underlying testing exercises were completed in an academic software-testing course. This cleaned portfolio version removes student numbers, course handouts, supplied binaries/source, IDE metadata, screenshots, and other classroom-only artifacts.

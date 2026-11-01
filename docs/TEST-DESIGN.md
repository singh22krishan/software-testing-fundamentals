# Test Design Notes

This portfolio reconstruction is based on testing exercises completed in COMP311 Software Testing. It keeps the testing techniques while replacing course-specific application code with small, self-contained examples.

## Equivalence Partitioning and Boundary Value Analysis

The grade classifier is divided into six valid equivalence partitions:

| Partition | Expected result |
|---|---|
| 90–100 | A+ |
| 80–<90 | A |
| 70–<80 | B |
| 60–<70 | C |
| 50–<60 | D |
| 0–<50 | F |

Values below 0 or above 100 are invalid partitions. The JUnit tests exercise both sides of each boundary instead of checking only representative middle values.

## Decision-Table Testing

The insurance example exercises combinations of:

- age over 55 with a good driving record;
- male driver under 25;
- business use;
- no special condition.

The bill-payment example preserves the ordered business-rule priority used in the coursework:

1. pay directly from checking when the balance covers the bill;
2. otherwise use qualifying overdraft protection and charge the service fee;
3. otherwise transfer the shortfall from savings when savings covers it;
4. otherwise decline payment, notify the client, and charge the service fee.

The tests are named after the behavior being verified so failures read like concise defect statements.

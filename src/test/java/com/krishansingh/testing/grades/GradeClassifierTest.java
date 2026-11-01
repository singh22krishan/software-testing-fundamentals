package com.krishansingh.testing.grades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GradeClassifierTest {
    @ParameterizedTest(name = "{0} should map to {1}")
    @CsvSource({
        "0,F", "49.99,F", "50,D", "59.99,D", "60,C", "69.99,C",
        "70,B", "79.99,B", "80,A", "89.99,A", "90,A+", "100,A+"
    })
    void classifiesBoundaryAndPartitionValues(double percentage, String expected) {
        assertEquals(expected, GradeClassifier.classify(percentage));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, 100.01})
    void rejectsValuesOutsideValidPartition(double percentage) {
        assertThrows(IllegalArgumentException.class, () -> GradeClassifier.classify(percentage));
    }
}

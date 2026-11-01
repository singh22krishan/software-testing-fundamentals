package com.krishansingh.testing.grades;

/** Classifies a numeric percentage into the grade partitions used in the coursework. */
public final class GradeClassifier {
    private GradeClassifier() {
    }

    public static String classify(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100");
        }
        if (percentage >= 90) {
            return "A+";
        }
        if (percentage >= 80) {
            return "A";
        }
        if (percentage >= 70) {
            return "B";
        }
        if (percentage >= 60) {
            return "C";
        }
        if (percentage >= 50) {
            return "D";
        }
        return "F";
    }
}

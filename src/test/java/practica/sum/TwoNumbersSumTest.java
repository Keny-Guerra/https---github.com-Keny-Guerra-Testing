package practica.sum;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class TwoNumbersSumTest {
    private final TwoNumbersSum adder = new TwoNumbersSum();

    @Test
    void addTwoNumbers_SameLength_NoCarry() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2)); // 12
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(3, 4)); // 34
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(4, 6)); // 46
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }

    @Test
    void addTwoNumbers_DifferentLength_WithCarry() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9)); // 99
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1)); // 1
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0, 0)); // 100
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }

    @Test
    void addTwoNumbers_WithCarryAtEnd() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9)); // 9
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1)); // 1
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0)); // 10
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }

    @Test
    void addTwoNumbers_EmptyLists() {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }

    @Test
    void addTwoNumbers_OneEmptyList() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2)); // 12
        ArrayList<Integer> second = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2)); // 12
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }

    @Test
    void addTwoNumbers_LargeNumbers() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(9, 9, 9)); // 999
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1)); // 1
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 0, 0, 0)); // 1000
        assertEquals(expected, adder.addTwoNumbers(first, second));
    }
}
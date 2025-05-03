package practica.sum;

import java.util.ArrayList;
import java.util.Collections;

// Source: https://leetcode.com/problems/add-two-numbers/description/
class TwoNumbersSum {

    public ArrayList<Integer> addTwoNumbers(ArrayList<Integer> first, ArrayList<Integer> second) {
        Collections.reverse(first);
        Collections.reverse(second);

        int complement = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < Math.max(first.size(), second.size()); i++) {
            int firstVal = i < first.size() ? first.get(i) : 0;
            int secondVal = i < second.size() ? second.get(i) : 0;
            int total = firstVal + secondVal + complement;
            complement = total / 10;
            result.add(total % 10);
        }

        // Añadir el acarreo final si existe
        if (complement > 0) {
            result.add(complement);
        }

        Collections.reverse(result);
        return result;
    }
}
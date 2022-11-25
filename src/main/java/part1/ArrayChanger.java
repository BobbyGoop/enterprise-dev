package main.java.part1;

import main.java.CustomArray;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayChanger extends CustomArray {
    public ArrayChanger(int min, int max, int count) {
        super(min, max, count);
    }

    public void reorderArray() {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> nullNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int j : this.originalArray) {
            if (j < 0) {
                negativeNumbers.add(j);
            } else if (j == 0) {
                nullNumbers.add(j);
            } else {
                positiveNumbers.add(j);
            }
        }
        ArrayList<Integer> result = CustomArray.concatCollectionArrays(negativeNumbers, nullNumbers, positiveNumbers);
        this.modifiedArray = result.stream().filter(Objects::nonNull).mapToInt(i -> i).toArray();
    }
}

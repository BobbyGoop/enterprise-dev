package main.java.part1;

import main.java.CustomArray;

public class ArrayShifter extends CustomArray {
    public ArrayShifter(int min, int max, int count) {
        super(min, max, count);
    }

    public void shiftArray(int shiftValue) {
        for (int i = 0; i < this.originalArray.length; i++)
            modifiedArray[i] = (shiftValue > 0) ?
                    originalArray[(i + shiftValue) % originalArray.length] :
                    originalArray[(originalArray.length + i + shiftValue) % originalArray.length];
    }
}

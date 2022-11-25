package com.company;

import java.util.ArrayList;
import java.util.Random;

public class CustomArray {
    public int minBound;
    public int maxBound;
    public int countNumbers;
    protected final int[] originalArray;
    protected int[] modifiedArray;

    public CustomArray(int min, int max, int count) {
        this.minBound = min;
        this.maxBound = max;
        this.countNumbers = count;
        this.originalArray = new int[this.countNumbers];
    }

    public void fillArrayWithRandom() {
        Random rd = new Random();
        this.modifiedArray = new int[this.originalArray.length];
        for (int i = 0; i < this.originalArray.length; i++) {
            this.originalArray[i] = rd.nextInt(maxBound - minBound) + minBound;
        }
    }

    protected static <T> ArrayList<T> concatCollectionArrays(ArrayList<T> array1, ArrayList<T> array2, ArrayList<T> array3) {
        ArrayList<T> resultList = new ArrayList<>(array1.size() + array2.size() + array2.size());
        resultList.addAll(array1);
        resultList.addAll(array2);
        resultList.addAll(array3);
        return resultList;
    }

    public int[] getModifiedArray() {
        return modifiedArray;
    }

    public int[] getOriginalArray() {
        return originalArray;
    }
}

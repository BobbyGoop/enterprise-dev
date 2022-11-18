package com.company.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ArrayShifter {
    public static void main(String[] args) {
        Random rd = new Random();
        int minBound = -20;
        int maxBound = 20;
        int countNumbers = 10;
        int shift = 11;

        int[] original = new int[countNumbers];
        int[] reordered = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            original[i] = rd.nextInt(maxBound-minBound) + minBound;

        }

        for(int i=0; i < original.length; i++)
            reordered[i] = original[Math.abs(shift-i) % original.length];

        System.out.println(Arrays.toString(original));
        System.out.println(Arrays.toString(reordered));
    }
}

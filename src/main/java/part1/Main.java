package main.java.part1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayShifter shifter = new ArrayShifter(-20, 20, 10);
        ArrayChanger changer = new ArrayChanger(-20, 20, 10);
        shifter.fillArrayWithRandom();
        changer.fillArrayWithRandom();

        System.out.println("Shifting array by 2 and -2");
        System.out.println(Arrays.toString(shifter.getOriginalArray()));
        shifter.shiftArray(2);
        System.out.println(Arrays.toString(shifter.getModifiedArray()));
        shifter.shiftArray(-2);
        System.out.println(Arrays.toString(shifter.getModifiedArray()));

        System.out.println("Reorder array");
        System.out.println(Arrays.toString(changer.getOriginalArray()));
        changer.reorderArray();
        System.out.println(Arrays.toString(changer.getModifiedArray()));
    }
}

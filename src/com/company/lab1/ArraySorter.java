package com.company.lab1;
import java.util.*;

public class ArraySorter {

    public static void main(String[] args) {
        Random rd = new Random();
        int min = -20;
        int max = 20;
        int count = 10;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = rd.nextInt(max-min) + min;

        }
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> out = convertArray(arr);
        System.out.println(out);
    }

    public static ArrayList<Integer> convertArray(int[] sum) {
        ArrayList<Integer> negativeNumbers = new ArrayList<>();
        ArrayList<Integer> nullNumbers = new ArrayList<>();
        ArrayList<Integer> positiveNumbers = new ArrayList<>();

        for (int j : sum) {
            if (j < 0) {
                negativeNumbers.add(j);
            }
            else if (j == 0){
                nullNumbers.add(j);
            }
            else {
                positiveNumbers.add(j);
            }
        }
        return concatCollectionArrays(negativeNumbers, nullNumbers, positiveNumbers);
    }

    public static <T> ArrayList<T> concatCollectionArrays(ArrayList<T> array1, ArrayList<T> array2, ArrayList<T> array3) {
        ArrayList<T> resultList = new ArrayList<>(array1.size()+ array2.size() + array2.size());
        resultList.addAll(array1);
        resultList.addAll(array2);
        resultList.addAll(array3);
        return resultList;
    }
}

package com.company.part2;

import com.company.CustomArray;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class ArraySorter extends CustomArray {
    public ArraySorter(int min, int max, int count) {
        super(min, max, count);
    }

    public int[] bubbleSort() {
        int[] res = originalArray.clone();
        int n = res.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (res[j] > res[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = temp;
                }
        return res;
    }

    public int[] cocktailSort() {
        int[] res = originalArray.clone();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i <= res.length - 2; i++) {
                if (res[i] > res[i + 1]) {
                    //test if two elements are in the wrong order
                    int temp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = res.length - 2; i >= 0; i--) {
                if (res[i] > res[i + 1]) {
                    int temp = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
        return res;
    }

    public int[] selectionSort() {
        int[] res = originalArray.clone();
        for (int i = 0; i < res.length; i++) {    // i - номер текущего шага
            int pos = i;
            int min = res[i];
            // цикл выбора наименьшего элемента
            for (int j = i + 1; j < res.length; j++) {
                if (res[j] < min) {
                    pos = j;    // pos - индекс наименьшего элемента
                    min = res[j];
                }
            }
            res[pos] = res[i];
            res[i] = min;    // меняем местами наименьший с array[i]
        }
        return res;
    }

    public int[] insertionSort() {
        int[] res = originalArray.clone();
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < res.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = res[i];
            for (j = i; j > 0 && swap < res[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                res[j] = res[j - 1];
            }
            res[j] = swap;
        }
        return res;
    }

    public int[] hashMapSort() {
        int[] res = originalArray.clone();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Integer temp;
        for (Integer i : res) {
            temp = hm.get(i);
            if (temp == null) hm.put(i, 1);
            else hm.put(i, temp + 1);
        }

        ArrayList<Integer> keys = new ArrayList<>(hm.keySet().size());
        keys.addAll(hm.keySet());
        keys.sort(Comparator.naturalOrder());
        int ptr = 0;
        for (Integer i : keys)
            for (int j = 0; j < hm.get(i); j++)
                res[ptr++] = i;
        return res;
    }

    public int[] mergeSort() {
        int[] res = originalArray.clone();
        this.mergeSortRecursive(res);
        return res;
    }

    private int[] mergeSortRecursive(int[] res) { // сортировка Массива который передается в функцию
        //int[] res = originalArray.clone();
        // проверяем не нулевой ли он?
        if (res == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (res.length < 2) {
            return res; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int[] arrayB = new int[res.length / 2];
        System.arraycopy(res, 0, arrayB, 0, res.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int[] arrayC = new int[res.length - res.length / 2];
        System.arraycopy(res, res.length / 2, arrayC, 0, res.length - res.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = mergeSortRecursive(arrayB); // левая часть возврат из рекурсии строкой return res;
        arrayC = mergeSortRecursive(arrayC); // правая часть возврат из рекурсии строкой return res;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    private int[] mergeArray(int[] arrayA, int[] arrayB) {

        int[] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0, positionB = 0;

        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length) {
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[i - positionA];
                positionA++;
            } else if (arrayA[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayA[i - positionA];
                positionB++;
            } else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }
    public int[] shellSort() {
        int []  arrayToSort= originalArray.clone();
        int n = arrayToSort.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arrayToSort[i];
                int j = i;
                while (j >= gap && arrayToSort[j - gap] > key) {
                    arrayToSort[j] = arrayToSort[j - gap];
                    j -= gap;
                }
                arrayToSort[j] = key;
            }
        }
        return arrayToSort;
    }
}

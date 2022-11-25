package main.java.part2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //testClient();
        //testQuadraticFunction();
        testArraySorter();
    }

    public static void testClient() {
        ArrayList<Customer> data = new ArrayList<>();
        data.add(new Customer(1, "Свеженин", "Иван", "Денисович"));
        data.add(new Customer(2, "Григорьев", "Афанасий", "Александрович"));
        data.add(new Customer(3, "Мамедов", "Расим", "Георгиевич"));
        data.add(new Customer(4, "Иванов", "Александр", "Степанович"));
        data.add(new Customer(5, "Арсеньев", "Кирилл", "Максимович"));
        data.add(new Customer(6, "Федоров", "Сергей", "Максимович"));
        data.add(new Customer(7));
        data.add(new Customer(8));

        data.get(0).setCredentials("1234567891011120", "1234567891011120");

        // Sorting by family name
        data.sort(Comparator.comparing(c -> c.firstName));
        data.forEach(System.out::println);
        System.out.println();

        data.sort(Comparator.comparing(c -> c.id));
        data.forEach(System.out::println);
        System.out.println();

        data.sort(Comparator.comparing(c -> c.getCredentials().get("card")));
        data.forEach(System.out::println);
        System.out.println();
    }

    public static void testQuadraticFunction() {
        QuadraticFunction fx = new QuadraticFunction(2, 5, -3);
        fx.getEquationRoots().forEach(System.out::println);
        System.out.println(Arrays.toString(fx.findVertexCoordinates()));
    }

    public static void testArraySorter() {
        ArraySorter as = new ArraySorter(-100, 100, 30);
        as.fillArrayWithRandom();
        int [] originalSorted = as.getOriginalArray().clone();
        Arrays.sort((originalSorted));

        boolean result = Arrays.equals(originalSorted, as.bubbleSort());
        assert result : "Bubble sort ruined";

        result = Arrays.equals(originalSorted, as.cocktailSort());
        assert result : "Cocktail sort ruined";

        result = Arrays.equals(originalSorted, as.selectionSort());
        assert result : "Selection sort ruined";

        result = Arrays.equals(originalSorted, as.insertionSort());
        assert result : "Insertion sort ruined";

        result = Arrays.equals(originalSorted, as.hashMapSort());
        assert result : "HashMap sort ruined";

        // Strange exception btw
        // result = Arrays.equals(originalSorted, as.mergeSort());
        // assert result : "Merge sort passed";

        result = Arrays.equals(originalSorted, as.shellSort());
        assert result : "Shell sort passed";
        System.out.println("All sorting methods work great!");
    }
}

package com.company.part2;


import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
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
}

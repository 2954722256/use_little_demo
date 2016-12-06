package com.aohuan.dodo.javacode.lambda.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 *
 * @author Alin
 *
 * Created by dodo_lihao on 2016/12/2.
 * qq: 2390183798
 *
 */
public class Example3 {
    static List<Person> javaProgrammers;
    static List<Person> phpProgrammers;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        addData();

        forEachPrint();

        filterPrint();

        sortedPrint();

        mapCollectPrint();

        streamSumPrint();

    }

    private static void filterPrint(){
        // filter examples
        // Print PHP programmers that earn more than $1,400
        System.out.println("\nPHP programmers that earn more than $1,400:");
        phpProgrammers.stream()
                .filter((p) -> (p.getSalary() > 1400))
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // Define some filters
        Predicate<Person> ageFilter = (p) -> (p.getAge() > 25);
        Predicate<Person> salaryFilter = (p) -> (p.getSalary() > 1400);
        Predicate<Person> genderFilter = (p) -> ("female".equals(p.getGender()));

        System.out.println("\n\nFemale PHP programmers that earn more than $1,400 and are older than 24 years:");
        phpProgrammers.stream()
                .filter(ageFilter)
                .filter(salaryFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // Reuse filters
        System.out.println("\n\nFemale Java programmers older than 24 years:");
        javaProgrammers.stream()
                .filter(ageFilter)
                .filter(genderFilter)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // limit examples
        System.out.println("\n\nPrint first 3 Java programmers:");
        javaProgrammers.stream()
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        System.out.println("\n\nPrint first 3 female Java programmers:");
        javaProgrammers.stream()
                .filter(genderFilter)
                .limit(3)
                .forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
    }


    /**
     * sorted, collect, limit, min, max examples
     */
    private static void sortedPrint(){
        // sorted, collect, limit, min, max examples
        System.out.println("\n\nSort and print first 5 Java programmers by name:");
        List<Person> sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getFirstName().compareTo(p2.getFirstName())))
                .limit(5)
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        System.out.println("\nSort and print Java programmers by salary:");
        sortedJavaProgrammers = javaProgrammers
                .stream()
                .sorted((p, p2) -> (p.getSalary() - p2.getSalary()))
                .collect(toList());

        sortedJavaProgrammers.forEach((p) -> System.out.printf("%s %s; %n", p.getFirstName(), p.getLastName()));

        // min is faster than sorting and choosing the first
        System.out.println("\nGet the lowest Java programmer salary:");
        Person pers = javaProgrammers
                .stream()
                .min((p1, p2) -> (p1.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", pers.getFirstName(), pers.getLastName(), pers.getSalary());

        System.out.println("\nGet the highest Java programmer salary:");
        Person person = javaProgrammers
                .stream()
                .max((p, p2) -> (p.getSalary() - p2.getSalary()))
                .get();

        System.out.printf("Name: %s %s; Salary: $%,d.", person.getFirstName(), person.getLastName(), person.getSalary());

    }


    /**
     * map, collect examples
     */
    private static void mapCollectPrint() {
        // map, collect examples
        System.out.println("\nGet PHP programmers first name to String:");
        String phpDevelopers = phpProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(joining(" ; "));    // this can be use as a token in further operations

        System.out.println(phpDevelopers);

        System.out.println("\nGet Java programmers first name to Set:");
        Set<String> javaDevFirstName = javaProgrammers
                .stream()
                .map(Person::getFirstName)
                .collect(toSet());

        javaDevFirstName.stream().forEach((s) -> System.out.printf("%s ", s));

        System.out.println("\nGet Java programmers last name to TreeSet:");
        TreeSet<String> javaDevLastName = javaProgrammers
                .stream()
                .map(Person::getLastName)
                .collect(toCollection(TreeSet::new));

        javaDevLastName.stream().forEach((s) -> System.out.printf("%s ", s));

        int numProcessorsOrCores = Runtime.getRuntime().availableProcessors();
        System.out.printf("\n\nParallel version on %s-core machine:", numProcessorsOrCores);
    }

    /**
     * parrallel stream, sum examples
     */
    private static void streamSumPrint() {
        // parrallel stream, sum examples
        System.out.println("\nCalculate total money spent for paying Java programmers:");
        int totalSalary = javaProgrammers
                .parallelStream()
                .mapToInt(p -> p.getSalary())
                .sum();

        System.out.printf("Money spent for paying Java programmers: $%,d %n", totalSalary);

        //Get count, min, max, sum, and average for numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics stats = numbers
                .stream()
                .mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }


    /**
     * forEach examples
     */
    private static void forEachPrint() {
        // forEach examples
        // Print programmers name
        System.out.println("Print programmers names:");
        javaProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));
        phpProgrammers.forEach((p) -> System.out.printf("%s %s; ", p.getFirstName(), p.getLastName()));

        // Increase salary by 5% to programmers
        System.out.println("\n\nIncrease salary by 5% to programmers:");
        Consumer<Person> giveRaise = e -> e.setSalary(e.getSalary() / 100 * 5 + e.getSalary());

        javaProgrammers.forEach(giveRaise);
        phpProgrammers.forEach(giveRaise);
        javaProgrammers.forEach((p) -> System.out.printf("%s earns now $%,d.%n", p.getFirstName(), p.getSalary()));
        phpProgrammers.forEach((p) -> System.out.printf("%s earns now $%,d.%n", p.getFirstName(), p.getSalary()));
    }

    /**
     * Data
     */
    private static void addData() {
        javaProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
                add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
                add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
                add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
                add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
                add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
                add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
                add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
                add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
                add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
            }
        };

        phpProgrammers = new ArrayList<Person>() {
            {
                add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
                add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
                add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
                add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
                add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
                add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
                add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
                add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
                add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
                add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
            }
        };
    }

}

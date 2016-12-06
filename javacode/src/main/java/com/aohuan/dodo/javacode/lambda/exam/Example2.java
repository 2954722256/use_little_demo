package com.aohuan.dodo.javacode.lambda.exam;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Alin
 *
 * Created by dodo_lihao on 2016/12/2.
 * qq: 2390183798
 */
public class Example2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] players = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner"};

        // Show the list of players
        System.out.print("Show the list of players:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // Sort players by name using anonymous innerclass
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });

        // Sort players by name using lambda expression
        Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));
        Arrays.sort(players, sortByName);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.compareTo(s2)));

        System.out.print("\nShow the list of players after sorting by name:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // Sort players by surname using anonymous innerclass
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
            }
        });

        // Sort players by surname using lambda expression
        Comparator<String> sortBySurname = (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" "))));
        Arrays.sort(players, sortBySurname);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.substring(s1.indexOf(" ")).compareTo(s2.substring(s2.indexOf(" ")))));

        System.out.print("\nShow the list of players after sorting by surname:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // Sort players by name lenght using anonymous innerclass
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.length() - s2.length());
            }
        });

        // Sort players by name lenght using lambda expression
        Comparator<String> sortByNameLenght = (String s1, String s2) -> (s1.length() - s2.length());
        Arrays.sort(players, sortByNameLenght);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.length() - s2.length()));

        System.out.print("\nShow the list of players after sorting by length:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));

        // Sort players by last letter using anonymous innerclass
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
            }
        });

        // Sort players by last letter using lambda expression
        Comparator<String> sortByLastLetter = (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1));
        Arrays.sort(players, sortByLastLetter);
        // or this
        Arrays.sort(players, (String s1, String s2) -> (s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1)));

        System.out.print("\nShow the list of players after sorting by last letter:\n");
        Arrays.asList(players).forEach((player) -> System.out.println(player));
    }

}

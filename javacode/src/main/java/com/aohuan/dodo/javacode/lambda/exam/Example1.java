package com.aohuan.dodo.javacode.lambda.exam;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Alin
 *
 * Created by dodo_lihao on 2016/12/2.
 * qq: 2390183798
 *
 */
public class Example1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listAbout();
        threadAbout();
    }

    private static void threadAbout() {
        // Using anonymous innerclass
        oldThreadPrint();

        // Using lambda expression
        // 用 lambda表达式
        new Thread(() -> System.out.println("Hello world !")).start();

        // Using anonymous innerclass
        // 用 匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // Using lambda expression
        // 用 lambda表达式
        Runnable race2 = () -> System.out.println("Hello world !");

        // Run em!
        race1.run();
        race2.run();
    }

    private static void listAbout() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic", "Stanislas Wawrinka", "David Ferrer", "Roger Federer", "Andy Murray", "Tomas Berdych", "Juan Martin Del Potro", "Richard Gasquet", "John Isner"};
        List<String> players =  Arrays.asList(atp);

        // Old looping
        oldLooping(players);

//        System.out.println("");

        // Using lambda expression and functional operations
        newLambdaList(players);

//        System.out.println("");

        // Using double colon operator in Java 8
        doubleColonOperator();


//        System.out.println("");
    }

    /**
     * Using double colon operator in Java 8
     * 用java8中的 ::
     */
    private static void doubleColonOperator() {
        players.forEach(System.out::println);
    }

    /**
     * Using anonymous innerclass
     * 用匿名内部类打印
     */
    private static void oldThreadPrint() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        }).start();
    }

    /**
     * Using lambda expression and functional operations
     * 用 lambda表达式 和 函式操作
     * @param players
     */
    private static void newLambdaList(List<String> players) {
        players.forEach((player) -> System.out.print(player + "; "));
    }

    /**
     * Old looping
     * 旧的 forEach 循环
     * @param players
     */
    private static void oldLooping(List<String> players) {
        for (String player : players) {
            System.out.print(player + "; ");
        }
    }

}

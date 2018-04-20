package com.blacksatan.dev;

import java.util.Arrays;
import java.util.List;

public class FuzzySetTrapezoidIntervals {
    public static List<Integer> badTeam = Arrays.asList(1, 1, 2, 3);
    public static List<Integer> middleTeam = Arrays.asList(1, 2, 3, 4);
    public static List<Integer> goodTeam = Arrays.asList(3, 4, 5, 5);

    public static List<Integer> badManage = Arrays.asList(1, 1, 2, 3);
    public static List<Integer> goodManage = Arrays.asList(2, 3, 4, 4);

    public static List<Integer> lowLoad = Arrays.asList(1, 1, 50, 100);
    public static List<Integer> middleLoad = Arrays.asList(50, 100, 500, 1000);
    public static List<Integer> highLoad = Arrays.asList(500, 10000, 1000000, 1000000);

    public static List<Integer> lowSalary = Arrays.asList(1, 1, 500, 1300);
    public static List<Integer> middleSalary = Arrays.asList(1000, 1500, 2500, 3000);
    public static List<Integer> highSalary = Arrays.asList(3000, 5000, 100000, 100000);

    public static List<Integer> smallTeam = Arrays.asList(1, 1, 3, 15);
    public static List<Integer> avgTeam = Arrays.asList(3, 8, 15, 70);
    public static List<Integer> bigTeam = Arrays.asList(8, 25, 1000, 1000);

    public static List<Integer> wpStack = Arrays.asList(0, 0, 5, 10);
    public static List<Integer> laraStack = Arrays.asList(9, 15, 20, 25);
    public static List<Integer> pyStack = Arrays.asList(20, 30, 40, 45);
    public static List<Integer> javaStack = Arrays.asList(40, 50, 60, 80);
    public static List<Integer> haskellStack = Arrays.asList(75, 80, 100, 100);

}

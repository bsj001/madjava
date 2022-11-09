package org.example.enumSet;

import java.util.EnumSet;
import java.util.HashSet;

public class TestEnumSet {
    public static void main(String[] args) {
        HashSet<Season> seasons = new HashSet<>();
        seasons.clear();
        seasons.add(Season.FALL);
        seasons.add(Season.SPRING);

        EnumSet<Season> enumSet = EnumSet.copyOf(seasons);

        System.out.println(enumSet);
    }
}

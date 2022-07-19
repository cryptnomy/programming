package sds_algorithm.src.DAY02.SortTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        Item item1 = new Item(1, 3, 1);
        Item item2 = new Item(1, 2, 3);
        Item item3 = new Item(1, 1, 2);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Comparator<Item> comp = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        };

        Collections.sort(list, comp);   // 기존 comparator 무효화
        System.out.println(list);
        // interface method 문법. function을 객체처럼 쓰는 방법
        Collections.sort(list, Comparator.comparingInt(Item::getB).reversed().thenComparingInt(Item::getC));
        // 유의: reversed는 한 개 정도만 쓰든지, 직접 compareTo를 구현하는 것을 추천
        System.out.println(list);
    }
}

class Item implements Comparable<Item> {
    int a;
    int b;
    int c;

    public Item(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override   // alt + insert in intellij
    public String toString() {
        return "{" + "a=" + a + ", b=" + b + ", c=" + c + "}";
    }

    @Override
    public int compareTo(Item o) {
        // 음수 -> 원래 순서
        // 0
        // 양수 -> swap
        //return b - o.b;
        //return Integer.compare(b, o.b);
        if (a > o.a) {
            return -1;
        } else if (a == o.a) {
            return b - o.b;
        } else {
            return 1;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
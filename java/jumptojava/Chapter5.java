package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;

class Calculator {
    int value;
    // Constructor
    Calculator() {
        this.value = 0;
    }

    void add(int val) {
        this.value += val;
    }

    int getValue() {
        return this.value;
    }

    boolean isOdd(int num) {
        return num % 2 == 1;
    }
    // Q4. Average of list members
    double avg(int[] data) {
        double total = 0;
        for (int num : data) {
            total += num;
        }
        return total / data.length;
    }

    double avg(ArrayList<Integer> data) {
        return data.stream()
                   .mapToInt(val -> val)
                   .average().orElse(0.0);
    }
}
// Q1. UpgradeCalculator class that inherits Calculator class
//       and contains minus method
class UpgradeCalculator extends Calculator {
    void minus(int val) {
        this.value -= val;
    }
}
// Q2. Addition result limit = 100
class MaxLimitCalculator extends Calculator {
    void add(int val) {
        this.value += val;
        if (this.value >= 100) {
            this.value = 100;
        }
    }
}
// Q7. RawMaterialCalculator
abstract class RawMaterial {
    abstract int getValue();
}

class Gold extends RawMaterial {
    public int getValue() {
        return 100;
    }
}

class Silver extends RawMaterial {
    public int getValue() {
        return 90;
    }
}

class Bronze extends RawMaterial {
    public int getValue() {
        return 80;
    }
}

class MaterialCalculator {
    int value = 0;

    public void add(RawMaterial material) {
        this.value += material.getValue();
    }

    public int getValue() {
        return this.value;
    }
}

public class Chapter5 {
    public static void main(String[] args) {
        // Q1
        UpgradeCalculator cal = new UpgradeCalculator();
        cal.add(10);
        System.out.println(cal.getValue()); // 10
        cal.minus(3);
        System.out.println(cal.getValue()); // 7
        // Q2
        MaxLimitCalculator cal2 = new MaxLimitCalculator();
        cal2.add(50);
        System.out.println(cal2.getValue()); // 50
        cal2.add(60);
        System.out.println(cal2.getValue()); // 100
        // Q4
        Calculator cal4 = new Calculator();
        int[] data41 = {1, 3, 5, 7, 10};
        double avg41 = cal4.avg(data41);
        System.out.println(avg41);         // 5.2
        ArrayList<Integer> data42 = new ArrayList<>(Arrays.asList(1, 4, 5, 7, 10));
        double avg42 = cal4.avg(data42);
        System.out.println(avg42);         // 5.4
        // Q5
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 3));
        // b and a point out the same object.
        ArrayList<Integer> b = a;
        // c is independent of a, but has the same data as a.
        ArrayList<Integer> c = new ArrayList<>(a);
        a.add(4);
        System.out.println(Arrays.toString(b.toArray()));   // [1, 2, 3, 4]
        System.out.println(Arrays.toString(c.toArray()));   // [1, 2, 3]
        // Q7
        MaterialCalculator cal7 = new MaterialCalculator();
        cal7.add(new Gold());   // 100
        cal7.add(new Silver()); // 100 + 90 = 190
        cal7.add(new Bronze()); // 100 + 90 + 80 = 270
        cal7.add(new Bronze()); // 100 + 90 + 80 + 80 = 350
        System.out.println(cal7.getValue());
    }
}

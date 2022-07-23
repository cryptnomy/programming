package jumptojava;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SampleStatic {
    public static void main(String[] args) throws IOException {
        // (ex 1)
        HouseLee l1 = new HouseLee();
        HouseLee l2 = new HouseLee();
        System.out.println(HouseLee.lastname);
        // (ex 2)
        Counter2 c1 = new Counter2();
        Counter2 c2 = new Counter2();
        //System.out.println(Counter2.count);
        // SimpleDateFomrat class
        System.out.println(Util.getCurrentDate("yyyy-MM-dd HH:mm:ss"));

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }
}

class HouseLee {
    // Likely to share lastname variable -> static ... memory allocation once
    // To be fixed? -> final
    static String lastname = "Lee"; 
}

class Counter2 {
    static int count = 0;

    Counter2() {
        ++count;
        System.out.println(Counter2.getCount());
    }
    
    public static int getCount() {
        return count;
    }
}

class Util {
    public static String getCurrentDate(String fmt) {
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        return sdf.format(new Date());
    }
}

class Singleton {
    private static Singleton one;

    private Singleton() {

    }
    // one object created just for once.
    public static Singleton getInstance() {
        if (one == null) {
            one = new Singleton();
        }
        return one;
    }
}

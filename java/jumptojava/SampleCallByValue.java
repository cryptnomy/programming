package jumptojava;

class Updater {
    void update(int count) {
        count++;            // Change will be in the local variable only
    }

    void update2(Counter counter) {
        counter.count++;    // Change will be in the instance variable
    }
}

class Counter {
    int count = 0;  // object variable
}

public class SampleCallByValue {
    public static void main(String[] args) {
        Counter myCounter = new Counter();
        System.out.println("before update: " + myCounter.count); // 0
        Updater myUpdater = new Updater();
        myUpdater.update(myCounter.count);
        System.out.println("after update: " + myCounter.count);  // 0
        myUpdater.update2(myCounter);
        System.out.println("after update2: " + myCounter.count); // 1
    }
}

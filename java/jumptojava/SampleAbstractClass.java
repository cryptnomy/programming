package jumptojava;

abstract class Predator extends Animal {
    abstract String getFood();

    void printFood() {
        System.out.printf("My food is %s\n", getFood());
    }

    static int LEG_COUNT = 4;

    static int speed() {
        return LEG_COUNT * 30;
    }
}

interface Barkable {
    void bark();
}
/*
interface BarkablePredator extends Predator, Barkable {
}
*/
class Animal {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

class Tiger extends Predator implements Barkable {
    public String getFood() {
        return "apple";
    }

    public void bark() {
        System.out.println("어흥");
    }
}

class Lion extends Predator implements Barkable {
    public String getFood() {
        return "banana";
    }

    public void bark() {
        System.out.println("으르렁");
    }
}

class ZooKeeper {
    void feed(Predator predator) {
        System.out.println("Feed " + predator.getFood());
    }
}

class Bouncer {
    void barkAnimal(Barkable animal) {
        animal.bark();
    }
}

public class SampleAbstractClass {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Lion lion = new Lion();

        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);
    }
}

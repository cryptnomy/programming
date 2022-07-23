package jumptojava;

import java.io.IOException;

public class SampleException {
    public void shouldBeRun() {
        System.out.println("ok thanks");
    }

    public void sayNick(String nick) {
        if ("fool".equals(nick)) {
            throw new FoolException();
        }
        System.out.println("Your nickname is " + nick + ".");
    }

    public static void main(String[] args) throws IOException {
        // Arithmetic Exception error example
        SampleException sample = new SampleException();
        int c;
        try {
            c = 4 / 0;
        } catch (ArithmeticException e) {
            c = -1;
        } finally {
            sample.shouldBeRun();
        }
        // RuntimeException and Exception
        SampleException se = new SampleException();
        try {
            se.sayNick("fool");
            se.sayNick("genious");
        } catch (FoolException e) {
            System.out.println("FoolException error has been occurred.");
        }
    }
}

class FoolException extends RuntimeException {

}

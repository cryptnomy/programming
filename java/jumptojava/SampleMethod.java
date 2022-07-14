package jumptojava;

public class SampleMethod {
    int sum(int a, int b) { // a, b: parameters
        return a + b;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        SampleMethod s = new SampleMethod();
        int c = s.sum(a, b);    // a, b: arguments
        System.out.println(c);
    }
}

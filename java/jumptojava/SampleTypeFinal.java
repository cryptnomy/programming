package jumptojava;

public class SampleTypeFinal {
    public static void main(String[] args) {
        // Integer.parseInt (string to int)
        String num1 = "123";
        int n1= Integer.parseInt(num1);
        System.out.println(n1); // 123
        // String.valueOf
        // Integer.toString (int to string)
        int n2 = 1234;
        String num2 = "" + n2;
        System.out.println(num2);   // 1234
        int n3 = 12345;
        String num31 = String.valueOf(n3);
        String num32 = Integer.toString(n3);
        System.out.println(num31);  // 12345
        System.out.println(num32);  // 12345
        // parseDouble
        String num4 = "123.456";
        double d4 = Double.parseDouble(num4);
        System.out.println((d4));
        // final
        // final ArrayList<String> a = new ArrayList<>(Arrays.asList("a", "b"));
        // Error occurs
        // a = new ArrayList<>(Arrays.asList(1, 2));
    }
}

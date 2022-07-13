package jumptojava;

public class SampleString {
    public static void main(String[] args) {
        char a = '\u0061';
        System.out.println(a);
        String b = "Hello";
        String c = "Hello";
        // equals method
        System.out.println(b.equals(c));
        // Index:   0123456789
        String d = "Hello Java";
        // Below are some methods for string primitivie type.
        // indexOf
        System.out.println(d.indexOf("Java"));
        System.out.println(d.indexOf("java"));
        // contains
        System.out.println(d.contains("Java"));
        System.out.println(d.contains("java"));
        // charAt
        System.out.println(d.charAt(6));
        // replaceAll
        System.out.println(d.replaceAll("Java", "World"));
        // substring
        System.out.println(d.substring(0, 4));
        // toUpperCase
        System.out.println(d.toUpperCase());
        // split
        String[] d2 = d.split(" ");
        // Formatting
        System.out.println(String.format("I have %d apples.", 3));
        System.out.println(String.format("I have %s apples.", "three"));
        // %s string; %c character; %d integer; %f floating-point;
        // %o octal; %x hexadecimal; %% literal %;
        // %s automatically transforms 3.234 to string format.
        System.out.println(String.format("rate is %s", 3.234));
        System.out.println(String.format("Error rate is %d%%.", 99));
        // Use format code with numbers.
        System.out.println(String.format("%-10s", "hi"));
        System.out.println(String.format("%10s", "hi"));
        // Align right the given number of 4 decimal places with total length 7
        System.out.println(String.format("%7.4f", 3.141592));
        // printf
        System.out.printf("I eat %d apples.", 3);
        /* String.format vs. System.out.printf
         * The former ~ method that returns string
         * The latter ~ method that prints string
         */
    }
}

package jumptojava;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SampleConsoleIO {
    public static void main(String[] args) throws IOException {
        // one character
        InputStream in1 = System.in;
        int s1 = in1.read();
        System.out.println(s1);
        // InputStream ... byte
        InputStream in2 = System.in;
        byte[] s2 = new byte[3];
        in2.read(s2);
        System.out.println(s2[1]);
        // InputStreamReader ... character
        InputStream in3 = System.in;
        InputStreamReader reader3 = new InputStreamReader(in3);
        char[] s3 = new char[3];
        reader3.read(s3);
        System.out.println(s3);
        // BufferedStream ... string
        InputStream in4 = System.in;
        InputStreamReader reader4 = new InputStreamReader(in4);
        BufferedReader br4 = new BufferedReader(reader4);
        String s4 = br4.readLine();
        System.out.println(s4);
    }
}

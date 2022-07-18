package jumptojava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Chapter6 {
    public static void main(String[] args) throws IOException {
        String filepath = "c:/Users/after/Documents/Programming/java/jumptojava/";
        //String filepath = "d:/GT/Programming/java/jumptojava/";
        // Q1. Sum of two integers
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int res = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        System.out.println(res);
        // Q2. Convert to capital letters until user types "END"
        while (true) {
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Type in English sentece: ");
            String line = br2.readLine();
            if ("END".equals(line)) break;
            System.out.println(line.toUpperCase());
        }
        // Q3. Save a file and then read it
        FileWriter fw3 = new FileWriter(filepath + "WriteOnce.txt");
        fw3.write("Write once, run anywhere\n");
        fw3.close();
        BufferedReader br3 = new BufferedReader(new FileReader(filepath + "WriteOnce.txt"));
        String line3 = br3.readLine();
        System.out.println(line3);
        br3.close();    // why needed?
        // Q4. Write a user input to a file
        FileWriter fw4 = new FileWriter(filepath + "KeepContents.txt", true);
        System.out.println("Enter a sentence: ");
        BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
        String line4 = br4.readLine();
        fw4.write(String.format("%s\n", line4));
        fw4.close();
        // Q5. Replace contents in a file
        ArrayList<String> al5 = new ArrayList<>();
        BufferedReader br5 = new BufferedReader(new FileReader(filepath + "PythonSaying.txt"));
        while (true) {
            String line5 = br5.readLine();
            if (line5 == null) break;
            al5.add(line5);
        }
        br5.close();
        String text5 = String.join("\n", al5);
        text5 = text5.replaceAll("Python", "Java");
        FileWriter fw5 = new FileWriter(filepath + "PythonSaying.txt");
        fw5.write(text5);
        fw5.close();
    }
}

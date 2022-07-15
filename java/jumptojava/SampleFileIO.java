package jumptojava;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SampleFileIO {
    public static void main(String[] args) throws IOException {
        // String filepath = "c:/Users/after/Documents/Programming/java/jumptojava/";
        String filepath = "d:/GT/Programming/java/jumptojava/";
        // FileOutputStream ... string -> byte conversion needed
        FileOutputStream fos = new FileOutputStream(filepath + "out_FileOutputStream.txt");
        for (int i = 1; i < 11; i++) {
            String data = i + "th line\r\n";
            fos.write(data.getBytes()); 
        }
        fos.close();
        // FileWriter
        FileWriter fw = new FileWriter(filepath + "out_FileWriter.txt");
        for (int i = 1; i < 11; i++) {
            String data = i + "th line\r\n";
            fw.write(data);
        }
        fw.close();
        // PrintWriter
        PrintWriter pw = new PrintWriter(filepath + "out_PrintWriter.txt");
        for (int i = 1; i < 11; i++) {
            String data = i + "th line";
            pw.println(data);
        }
        pw.close();
        // Add contents to a file
        FileWriter fw2 = new FileWriter(filepath + "out_FileWriter.txt", true);
        for (int i = 11; i < 21; i++) {
            String data = i + "th line.\r\n";
            fw2.write(data);
        }
        fw2.close();
        // BufferedReader, FileReader
        BufferedReader br = new BufferedReader(new FileReader(filepath + "out_FileWriter.txt"));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        br.close();
    }
}

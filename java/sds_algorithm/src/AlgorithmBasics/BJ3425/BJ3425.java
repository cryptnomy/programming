package AlgorithmBasics.BJ3425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class BJ3425 {
    static List<String> list = new ArrayList<>();
    static int listSize;
    static long[] stack = new long[1001];
    static int head;
    static int N;
    static int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            list.clear();
            String line = br.readLine();
            // QUIT
            if (line.equals("QUIT")) { break; }
            // Instructions to list until "END"
            while (!line.equals("END")) {
                if (line.length() == 3) {
                    list.add(line);
                } else {    // for "NUM X"
                    list.add(line.substring(0, 3)); // NUM
                    list.add(line.substring(4));             // X
                }
                line = br.readLine();
            }
            // N
            N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                if (executeInstructions(num)) { sb.append(stack[0]).append("\n"); }
                else { sb.append("ERROR\n"); }
            }
            sb.append("\n");
            br.readLine();
        }
        System.out.print(sb);
    }
    /* return false if error occurs or stack does not have
     * one element when all instructions ended.
     */
    static boolean executeInstructions(long x) {
        // Stack initialization
        head = 0;
        stack[head++] = x;
        // Instructions of list size
        listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            if (list.get(i).equals("NUM")) {
                stack[head++] = Long.parseLong(list.get(i + 1));
                ++i;
                //System.out.println(Arrays.toString(stack));
            } else if (list.get(i).equals("POP")) {
                if (head < 1) { return false; }
                --head;
            } else if (list.get(i).equals("INV")) {
                if (head < 1) { return false; }
                stack[head-1] *= -1;
            } else if (list.get(i).equals("DUP")) {
                if (head < 1) { return false; }
                stack[head] = stack[head-1];
                ++head; // stack[head++] = stack[head-1]; -> bug occurs
            } else if (list.get(i).equals("SWP")) {
                if (head < 2) { return false; }
                long temp = stack[head-1];
                stack[head-1] = stack[head-2];
                stack[head-2] = temp;
            } else if (list.get(i).equals("ADD")) {
                if (head < 2) { return false; }
                long temp = stack[head-2] + stack[head-1];
                if (Math.abs(temp) > MAX) { return false; }
                stack[head - 2] = temp;
                --head;
            } else if (list.get(i).equals("SUB")) {
                if (head < 2) { return false; }
                long temp = stack[head-2] - stack[head-1];
                if (Math.abs(temp) > MAX) { return false; }
                stack[head - 2] = temp;
                --head;
            } else if (list.get(i).equals("MUL")) {
                if (head < 2) { return false; }
                long temp = stack[head-2] * stack[head-1];
                if (Math.abs(temp) > MAX) { return false; }
                stack[head - 2] = temp;
                --head;
            } else if (list.get(i).equals("DIV")) {
                if (head < 2 || stack[head-1] == 0) { return false; }
                stack[head-2] /= stack[head-1];
                --head;
            } else if (list.get(i).equals("MOD")) {
                if (head < 2 || stack[head-1] == 0) { return false; }
                stack[head-2] %= stack[head-1];
                --head;
            }
        }
        if (head == 1) { return true; }
        else { return false; }
    }
}

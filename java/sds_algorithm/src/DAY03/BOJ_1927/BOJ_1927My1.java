package DAY03.BOJ_1927;

import java.io.*;
import java.util.*;

public class BOJ_1927My1 {
    static int N;
    static Heap q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        q = new Heap();

        int x;
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                // heap pop
                bw.append(q.pop() + "\n");
                continue;
            }
            // heap insert
            q.add(x);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Heap {
    List<Integer> q;

    public Heap() {
        this.q = new ArrayList<>();
        q.add(-1); // root
    }

    public void add(int x) {
        q.add(x);

        int current = q.size() - 1;
        int parent = current / 2;
        
        while (true) {
            if (parent == 0 || q.get(parent) <= q.get(current)) { break; }
            int temp = q.get(parent);
            q.set(parent, q.get(current));
            q.set(current, temp);
            current = parent;
            parent = current / 2;
        }
    }

    public int pop() {
        if (q.size() == 1) { return 0; }
        int head = q.get(1);
        q.set(1, q.get(q.size() - 1));
        q.remove(q.size() - 1);

        int currentPos = 1;
        while (true) {
            int leftPos = 2 * currentPos;
            int rightPos = 2 * currentPos + 1;
            
            if (leftPos >= q.size()) { break; }
            int minPos = currentPos;
            int minVal = q.get(currentPos);
            if (q.get(leftPos) <= minVal) {
                minPos = leftPos;
                minVal = q.get(leftPos);
            }

            if (rightPos >= q.size()) { break; }
            if (q.get(rightPos) <= minVal) {
                minPos = rightPos;
                minVal = q.get(rightPos);
            }

            if (minPos != currentPos) {
                int temp = q.get(currentPos);
                q.set(currentPos, minVal);
                q.set(minPos, temp);
                currentPos = minPos;
            }
        }
        return head;
    }
}

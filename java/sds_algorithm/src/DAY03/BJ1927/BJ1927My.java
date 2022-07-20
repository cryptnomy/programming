package sds_algorithm.src.DAY03.BJ1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// class MinHeap {
//     private int[] arr;
//     private int head = 1;
//     private int tail;

//     public MinHeap() {
//         this.arr = new int[2];
//         this.tail = 1;
//     }

//     public MinHeap(int len) {
//         this.arr = new int[len + 1];
//         this.tail = 1;
//     }

//     public void insert(int item) {
//         this.arr[++this.tail] = item;
//     }

//     public int remove(int item) {
//         int x = this.arr[1];
//         this.arr[1] = this.arr[this.tail--];
//         return x;
//     }

//     public void swap(int i, int j) {
//         return;
//     }

//     private int parent(int i) {
//         return i/2;
//     }

//     private int right(int i) {
//         return 2*i + 1;
//     }

//     private int left(int i) {
//         return 2*i;
//     }
// }

public class BJ1927My {
    static int N;
    static int tail;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            arr = new int[N+1];
            tail = 1;
            if (x == 0) {
                pop(arr, tail);
            } else if (x > 1) {

            }
        }
    }

    static int pop(int[] arr, int tail) {
        if (tail == 1) return 0;
        else if (tail > 1) {
            int x = arr[1];
            arr[1] = arr[tail--];   // last item to root
            minHeapify(arr);
            return x;
        }
        return 0;
    }

    static void minHeapify(int[] arr) {
        
    }
}

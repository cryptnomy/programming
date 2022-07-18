package sds_algorithm.src.DAY01.BJ3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Position {
    int row, col;
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class BJ3055My {
    static int R, C;
    static char[][] fields;
    static final String IMPOSSIBLE = "KAKTUS";
    static Queue<Position> painter = new ArrayDeque<>();
    static Queue<Position> water = new ArrayDeque<>();
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        fields = new char[R][C];
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                fields[r][c] = line.charAt(c);
            }
        }
    }

    static void bfs() {
        int 
    }

    static boolean isInField(int r, int c) {
        if (-1 < r &&  r < R && -1 < c && c < C) {
            return true;
        } else {
            return false;
        }
    }
}

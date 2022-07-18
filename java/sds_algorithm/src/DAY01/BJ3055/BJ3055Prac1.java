package sds_algorithm.src.DAY01.BJ3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055Prac1 {
    static int R, C;
    static char[][] fields;
    /*  possible data in fields
     *  . empty field(s)
     *  * flooded field(s)
     *  X rock(s)
     *  S source (painter)
     *  D destination
     */
    static int[][] dp;        // time elapse
    static int[] DY = {-1, 1, 0, 0};
    static int[] DX = {0, 0, -1, 1};
    static Queue<Point> q;
    static boolean foundAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        fields = new char[R][C];
        dp = new int[R][C];
        q = new LinkedList<>();

        Point sp = null;    // source point
        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                // Fill in fields' data with input data
                fields[r][c] = line.charAt(c);
                if (fields[r][c] == '*') {
                    // Flooded field found; Add to queue first
                    q.add(new Point(r, c, '*'));
                } else if (fields[r][c] == 'S') {
                    // Painter (source point) found
                    sp = new Point(r, c, 'S');
                }
            }
        }
        q.add(sp);  // q = ['*', 'S']

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]);
                foundAnswer = true;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = p.y + DY[i];
                int nx = p.x + DX[i];
                if (-1 < ny && ny < R && -1 < nx && nx < C) {
                    // p.type for current position information
                    // ny/nx for next position information
                    if (p.type == '*') {
                        // Flooded field spreads out
                        if (fields[ny][nx] == '.' || fields[ny][nx] == 'S') {
                            fields[ny][nx] = '*';
                            q.add(new Point(ny, nx, '*'));
                        }
                    } else if (p.type == '.' || p.type == 'S') {
                        // Painter (source point) moves
                        if (dp[ny][nx] == 0 && (fields[ny][nx] == '.' || fields[ny][nx] == 'D')) {
                            dp[ny][nx] = dp[p.y][p.x] + 1;
                            q.add(new Point(ny, nx, fields[ny][nx]));
                        }
                    }
                }
            }
        }
        if (!foundAnswer)
            System.out.println("KAKTUS");
    }   
}

class Point {
    int y;
    int x;
    char type;

    Point(int y, int x, char type) {
        this.y = y;
        this.x = x;
        this.type = type;
    }
}

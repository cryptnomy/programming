package DAY02.BJ1713;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1713SDS {
    static int N, K;
    static Nominee[] nominees;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/DAY02/BJ1713/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        nominees = new Nominee[101];

        List<Nominee> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            int num = Integer.parseInt(st.nextToken());
            // 해당 후보가 최초 호출 시
            if (nominees[num] == null) {
                nominees[num] = new Nominee(num, 0, 0, false);
            }
            // 해당 후보가 사진틀에 있을 경우
            if (nominees[num].isIn == true) {
                nominees[num].count++;
            } else {    // 해당 후보가 사진 틀에 없음
                // 사진틀이 가득 찬 경우
                if (list.size() == N) {
                    // 정렬, 지울 후보 선정, 제거
                    Collections.sort(list);
                    list.get(0).isIn = false;
                    list.remove(0); // 0번째 elem을 지우면서 메모리 부하가 커짐
            }
            // 사진틀에 여유가 있는 경우
            nominees[num].count = 1;
            nominees[num].isIn = true;
            nominees[num].timeStamp = k;
            list.add(nominees[num]);
            }
        }

        Collections.sort(list, new Comparator<Nominee>() {
            @Override
            public int compare(Nominee o1, Nominee o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) System.out.print(list.get(0).num + "");
            else System.out.print(" " + list.get(i).num);
        }
    }
}

class Nominee implements Comparable<Nominee> {
    int num;
    int count;
    int timeStamp;
    boolean isIn;

    public Nominee(int num, int count, int timeStamp, boolean isIn) {
        this.num = num;
        this.count = count;
        this.timeStamp = timeStamp;
        this.isIn = isIn;
    }

    // 1. 추천수, 2. 시간
    @Override
    public int compareTo(Nominee o) {
        int comp = Integer.compare(this.count, o.count);
        return comp == 0 ? Integer.compare(this.timeStamp, o.timeStamp) : comp;
    }

    @Override
    public String toString() {
        return "Nominee [count=" + count + ", isIn=" + isIn + ", num=" + num + ", timeStamp=" + timeStamp + "]";
    }
}

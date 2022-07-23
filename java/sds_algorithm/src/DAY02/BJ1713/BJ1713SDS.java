package DAY02.BJ1713;

//import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BJ1713SDS {
    static int N, K;
    static Nominee[] nominees;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/DAY02/BJ1713/input.txt"));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        nominees = new Nominee[101];

        List<Nominee> list = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            int num = sc.nextInt();
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
        sc.close();

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

    @Override
    public String toString() {
        return "{num=" + num +
               ", count=" + count +
               ", timeStamp=" + timeStamp +
               "}";
    }

    // 1. 추천수, 2. 시간
    @Override
    public int compareTo(Nominee o) {
        int comp = Integer.compare(count, o.count);
        if (comp == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp;
        }
    }
}

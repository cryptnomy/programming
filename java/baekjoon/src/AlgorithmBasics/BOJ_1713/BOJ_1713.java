package AlgorithmBasics.BOJ_1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1713 {
    static int N, K;
    static Recommendee[] recommendees;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        recommendees = new Recommendee[K]; // 추천 받은 자
        List<Recommendee> candidates = new ArrayList<>(); // 현재 후보군
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 처음 추천 받은 경우
            if (recommendees[num] == null) {
                recommendees[num] = new Recommendee(num, 0, 0, false);
            }
            // 추천 받은 자가 후보군에 있을 경우
            if (recommendees[num].isCandidate == true) {
                recommendees[num].likes++;
            } else { // 추천 받은 자가 후보군에 없을 경우
                // 후보군이 가득 찬 경우 후보 한 자리 비워주기
                if (candidates.size() == N) {
                    Collections.sort(candidates);
                    candidates.get(0).isCandidate = false;
                    candidates.remove(0);
                }
                // 후보 한 자리 채우기
                recommendees[num].likes = 1;
                recommendees[num].isCandidate = true;
                recommendees[num].timeStamp = i;
                candidates.add(recommendees[num]);
            }
        }

        Collections.sort(candidates, new Comparator<Recommendee>() {
            @Override
            public int compare(Recommendee o1, Recommendee o2) {
                return Integer.compare(o1.num, o2.num);
            }
        });

        for (int i = 0; i < candidates.size(); i++) {
            if (i == 0) {
                System.out.print(candidates.get(0).num + "");
            } else {
                System.out.print(" " + candidates.get(i).num);
            }
        }
    }
}

class Recommendee implements Comparable<Recommendee> {
    int num;
    int likes;
    int timeStamp;
    boolean isCandidate;

    public Recommendee(int num, int likes, int timeStamp, boolean isCandidate) {
        this.num = num;
        this.likes = likes;
        this.timeStamp = timeStamp;
        this.isCandidate = isCandidate;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Recommendee o) {
        int comp = Integer.compare(likes, o.likes);
        if (comp == 0) {
            return Integer.compare(timeStamp, o.timeStamp);
        } else {
            return comp;
        }
    }
}

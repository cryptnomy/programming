package sds_algorithm.src.DAY02.BJ1713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1713My {
    // 정렬 시엔 comparable 사용
    // 출력 시엔 comparator 사용
    static int N, Votes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Votes = Integer.parseInt(br.readLine());
        
        List<Student> frames = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ", false);
        for (int i = 0; i < Votes; i++) {
            int voteNum = Integer.parseInt(st.nextToken());
            boolean isInFrames = false;

            for (int j = 0; j < frames.size(); j++) {
                if (frames.get(j).num == voteNum) {
                    frames.set(j, new Student(voteNum, frames.get(j).votes + 1, frames.get(j).time));
                    isInFrames = true;
                    break;
                }
            }

            if (!isInFrames) {
                if (frames.size() < N) frames.add(new Student(voteNum, 1, i));
                else {
                    Collections.sort(frames, Comparator.comparing(Student::getTime)
                                                       .thenComparing(Student::getVotes));
                    frames.set(0, new Student(voteNum, 1, i));
                }
            }
        }

        Collections.sort(frames, Comparator.comparing(Student::getNum));
        for (int i = 0; i < frames.size(); i++) {
            if (i == 0) System.out.print(frames.get(0).num + "");
            else System.out.print(" " + frames.get(i).num);
        }
    }
}

class Student implements Comparable<Student> {
    int num;
    int votes;
    int time;

    public Student(int num, int votes, int time) {
        this.num = num;
        this.votes = votes;
        this.time = time;
    }

    @Override
    public int compareTo(Student o) {
        if (this.votes == o.votes) {
            return this.time - o.time;
        } else
            return this.votes - o.votes;
    }

    public int getNum() {
        return num;
    }

    public int getVotes() {
        return votes;
    }

    public int getTime() {
        return time;
    }
}

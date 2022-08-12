package DAY07.BOJ_2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Student {
	private int number;
	private List<Student> outAdj;
	private List<Student> inAdj;
	
	public Student(int number) {
		this.number = number;
		this.outAdj = new ArrayList<>();
		this.inAdj = new ArrayList<>();
	}
	
	public int getNumber() {
		return number;
	}
	
	public void addOutAdj(Student s) {
		outAdj.add(s);
	}
	
	public void addInAdj(Student s) {
		inAdj.add(s);
	}
	
	public List<Student> getOutAdj() {
		return outAdj;
	}
	
	public List<Student> getInAdj() {
		return inAdj;
	}
	
}

public class BOJ_2458Other1 {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Student[] students = new Student[N+1];
		for (int i = 1; i <=N; i++)
			students[i] = new Student(i);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Student from = students[Integer.parseInt(st.nextToken())];
			Student to = students[Integer.parseInt(st.nextToken())];
			from.addOutAdj(to);
			to.addInAdj(from);
		}
		int answer = 0;
		boolean[] visited = new boolean[N+1];
		for (int i = 1; i <=N ; i++) {
			int tallerCount = dfsOut(students[i],visited);
			int smallerCount = dfsIn(students[i],visited);
			initVisited(visited);
			if(tallerCount+smallerCount-1==N)
				answer++;
		}
		
		System.out.println(answer);
		
	}
	
	public static void initVisited(boolean[] visited) {
		for (int i = 1; i <=N ; i++)
			visited[i] = false;
	}

	public static int dfsOut(Student s, boolean[] visited) {
		int tallerCount = 1;
		List<Student> outAdj = s.getOutAdj();
		if(outAdj.size()==0)
			return 1;
		
		
		for (int i = 0; i < outAdj.size() ; i++) {
			Student next = outAdj.get(i);
			if(!visited[next.getNumber()]) {
				visited[next.getNumber()] = true;
				tallerCount+=dfsOut(next,visited);
			}
		}
		
		return tallerCount;
	}
	
	public static int dfsIn(Student s, boolean[] visited) {
		int smallerCount = 1;
		List<Student> inAdj = s.getInAdj();
		if(inAdj.size()==0)
			return 1;
		
		
		for (int i = 0; i < inAdj.size() ; i++) {
			Student next = inAdj.get(i);
			if(!visited[next.getNumber()]) {
				visited[next.getNumber()] = true;
				smallerCount+=dfsIn(next,visited);
			}

		}
		
		return smallerCount;
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] population;
	static int total_p = 0; // 총 인구
	static int answer = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Integer>> link = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		for(int i=0; i<=N; i++) { 
			link.add(new ArrayList<>());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) { // 인구수 저장
			population[i] = Integer.parseInt(st.nextToken());
			total_p += population[i]; 
		}
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				link.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		subset();
		if(answer == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static void subset() {
		boolean[] choose;
		for(int i=1; i<(1<<N); i++) {
			choose = new boolean[N+1];
			int cnt = 0; // true 개수
			for(int j=1; j<N; j++) {
				if((i&(1<<j)) != 0) {
					choose[j] = true;
					cnt++;
				}
			}
			check(choose,cnt);
		}
	}
	
	static void check(boolean[] choose,int cnt) {
		boolean[] copy = choose.clone();
		int red = bfs(copy,false,cnt); /// true -> false
		int blue = bfs(choose,true,N-cnt); // false -> true
		if(red!=-1 && blue!=-1) answer = Math.min(answer, Math.abs(red-blue));
	}
	
	static int bfs(boolean[] choose, boolean bool,int cnt) {
		Queue<Integer> q = new ArrayDeque<>();
		int people = 0;
		for(int i=1; i<=N; i++) { // 시작 위치 찾기
			if(choose[i] != bool) {
				choose[i] = bool;
				q.add(i);
				people += population[i];
				break;
			}
		}
		int found = 1;
		while(!q.isEmpty()) {
			int next = q.poll();
			for(int i:link.get(next)) {
				if(choose[i]!=bool) {
					choose[i] = bool;
					found++;
					people += population[i];
					q.add(i);
				}
			}
		}
		if(cnt==found) {
			return people;
		}
		return -1;
	}
}
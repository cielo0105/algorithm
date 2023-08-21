import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {	
	static ArrayList<Integer> list[]; 
	static int N,S,P;
	static List<Integer> count;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken()); // 지지대 1~S번
		P = Integer.parseInt(st.nextToken()); // 펭귄 위치
		list = new ArrayList[N+1];
		count = new ArrayList<>();
		visited = new boolean[N+1];
		visited[P] = true;
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[from].add(to);
			list[to].add(from);
		}
		
		for(int i: list[P]) {
			visited[i] = true;
			dfs(i,1);
		}
		Collections.sort(count);
		System.out.println(N-count.get(0)-count.get(1)-1);
	}
	
	static void dfs(int start, int cnt) {
		if(start <= S) {
			count.add(cnt);
			return;
		}
		for(int i:list[start]) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i,cnt+1);
				
			}
		}
		return;
	}
}
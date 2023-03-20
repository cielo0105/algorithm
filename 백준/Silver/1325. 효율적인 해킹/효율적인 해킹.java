
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static int[] ans; // 해킹할 수 있는 컴퓨터 개수
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		ans = new int[n+1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			bfs(i);
		}
		int max_n = Arrays.stream(ans).max().getAsInt();
		for (int i = 1; i <= n; i++) {
			if(ans[i] == max_n) 
				System.out.print(i+" ");
			
		}
	}
	
	
	
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int next = queue.poll();
			for (int  a : graph[next]) {
				if(visited[a] == false) {
					visited[a] = true;
					ans[a]++;
					queue.add(a);
				}
			}
		}
	}
}

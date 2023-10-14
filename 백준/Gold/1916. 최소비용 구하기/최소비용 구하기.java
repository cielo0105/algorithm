import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Info>> link = new ArrayList<>();
	static int[] dp;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 도시 개수
		int M = Integer.parseInt(br.readLine()); // 버스 개수
		int INF = 1000000000;
		dp = new int[N];
		visited = new boolean[N];
		Arrays.fill(dp, INF);
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			link.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int dist = Integer.parseInt(st.nextToken());
			link.get(from).add(new Info(to,dist));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken())-1;
		int end = Integer.parseInt(st.nextToken())-1;
		dijkstra(start);
		System.out.println(dp[end]);
	}
	
	static void dijkstra(int start) {
		dp[start] = 0; 
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(visited[info.x]) continue;
			visited[info.x] = true;
			for(Info next: link.get(info.x)) {
				if(!visited[next.x]) {
					if(dp[next.x]>dp[info.x]+next.dist) {
						dp[next.x] = dp[info.x]+next.dist;
						pq.add(new Info(next.x,dp[next.x]));
					}
					
				}
			}
		}
	}
	
	static class Info implements Comparable<Info>{
		int x, dist;
		public Info(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {
			return this.dist - o.dist;
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static List<Info>[] link;
	static boolean[] visited;
	static int[] dist, parent;
	static int INF = 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		link = new List[N+1];
		for(int i=0; i<=N; i++) {
			link[i] = new ArrayList<>();
		}
		dist = new int[N+1];
		parent = new int[N+1];
		Arrays.fill(dist, INF);
		visited = new boolean[N+1];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			link[from].add(new Info(to,cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijk(start);
		sb.append(dist[end]+"\n");
		List<Integer> answer = new ArrayList<>();
		while(true) {
			if(end == start) {
				answer.add(end);
				break;
			}
			answer.add(end);
			end = parent[end];
		}
		sb.append(answer.size()+"\n");
		for(int i=answer.size()-1; i>=0; i--) {
			sb.append(answer.get(i)+" ");
		}
		System.out.println(sb);
	}
	
	static void dijk(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(visited[info.x]) continue;
			visited[info.x] = true;
			for(Info next:link[info.x]) {
				if(dist[next.x] > dist[info.x]+next.cost) {
					dist[next.x] = dist[info.x]+next.cost;
					parent[next.x] = info.x;
					pq.add(new Info(next.x,dist[next.x]));
				}
			}
		}
	}
	
	static class Info implements Comparable<Info>{
		int x, cost;
		public Info(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
		@Override
		public int compareTo(Info o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return this.x+" "+this.cost;
		}
	}
}
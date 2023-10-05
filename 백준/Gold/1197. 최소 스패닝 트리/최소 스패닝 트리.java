import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E;
	static ArrayList<ArrayList<Info>> link = new ArrayList<>();
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		for(int i=0; i<=V; i++) {
			link.add(new ArrayList<>());
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			link.get(from).add(new Info(to,dist));
			link.get(to).add(new Info(from,dist));
		}
		prim(1);
		System.out.println(ans);
	}
	
	static void prim(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		for(Info next:link.get(start)) {
			pq.add(next);
		}
		visited[start] = true;
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(!visited[info.x]) {
				visited[info.x] = true;
				ans += info.dist;
				for(Info next: link.get(info.x)) {
					if(!visited[next.x]) pq.add(next);
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
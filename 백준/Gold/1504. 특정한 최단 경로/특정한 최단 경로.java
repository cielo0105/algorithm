import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 1->v1->v2->N
 * 1->v2->v1->N 
 * 둘 중 짧은 거리가 정답
 */
public class Main {
	static int N, E;
	static List<Info>[] link;
	static int INF = 200000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		link = new List[N+1];
		for(int i=0; i<=N; i++) {
			link[i] = new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			st =  new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			link[from].add(new Info(to,dist));
			link[to].add(new Info(from,dist));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		int answer = Math.min(dijk(1,v1) + dijk(v1,v2)+dijk(v2,N),dijk(1,v2)+dijk(v2,v1)+dijk(v1,N));
		if(answer >= INF) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static int dijk(int start, int end) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		boolean[] visited = new boolean[N+1];
		dist[start] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		while(!pq.isEmpty()) {
			Info info = pq.poll();
			if(visited[info.x]) continue;  // 이미 방문한 경우
			visited[info.x] = true;
			for(Info next:link[info.x]) {
				if(dist[next.x] > dist[info.x]+next.dist) {  // 기존 값보다 작은 경우 값 갱신
					dist[next.x] = dist[info.x]+next.dist;
					pq.add(new Info(next.x,dist[next.x]));
				}
			}
		}
		return dist[end];
	}
	
	static class Info implements Comparable<Info>{
		int x, dist;
		public Info(int x, int dist) {
			this.x = x;
			this.dist = dist;
		}
		@Override
		public int compareTo(Info o) {  // 거리 짧은 순으로 정렬
			return this.dist - o.dist;
		}
	}
}
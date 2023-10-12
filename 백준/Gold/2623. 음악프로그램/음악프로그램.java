import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * mst 프림 알고리즘
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] connected = new int[N];
		StringBuilder sb = new StringBuilder();
		ArrayList<ArrayList<Integer>> link = new ArrayList<>();
		for(int i=0; i<N; i++) {
			link.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken())-1;
			for(int j=0; j<num-1; j++) {
				int to = Integer.parseInt(st.nextToken())-1;
				link.get(from).add(to);
				connected[to]++;
				from = to;
			}
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(connected[i]==0) pq.add(i);
		}
		while(!pq.isEmpty()) {
			int next = pq.poll();
			if(!visited[next]) {
				visited[next] = true;
				sb.append((next+1)+"\n");
				cnt++;
				for(int li:link.get(next)) {
					connected[li]--;
				}
				for(int i=0; i<N; i++) {
					if(connected[i]==0 && !visited[i]) pq.add(i);
				}
			}
		}
		if(cnt==N) System.out.println(sb);
		else System.out.println(0);
	}
}
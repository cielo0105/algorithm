import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		ArrayList<ArrayList<Info>> link1 = new ArrayList<>();
		ArrayList<ArrayList<Info>> link2 = new ArrayList<>();
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		Arrays.fill(dp1, INF);
		Arrays.fill(dp2, INF);
		int M = Integer.parseInt(st.nextToken()); // 단방향 도로
		int X = Integer.parseInt(st.nextToken())-1; // 목적지
		int answer = 0;
		for (int i = 0; i < N; i++) {
			link1.add(new ArrayList<>());
			link2.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int dist = Integer.parseInt(st.nextToken());
			link1.get(from).add(new Info(to, dist));
			link2.get(to).add(new Info(from,dist));
		}

		dijkstra(X,link1,dp1);
		dijkstra(X,link2,dp2);
		for(int i=0; i<N; i++) {
			answer = Math.max(answer, dp1[i]+dp2[i]);
		}
		System.out.println(answer);
	}

	

	static void dijkstra(int start,ArrayList<ArrayList<Info>> link, int[] dp) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start, 0));
		dp[start] = 0;
		while (!pq.isEmpty()) {
			Info info = pq.poll();
			if (info.dist > dp[info.num])
				continue;
			for (Info next : link.get(info.num)) {
				if (dp[next.num] > dp[info.num] + next.dist) {
					dp[next.num] = dp[info.num] + next.dist;
					pq.add(new Info(next.num, dp[next.num]));
				}
			}
		}
	}

	static class Info implements Comparable<Info> {
		int num, dist;

		public Info(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Info o) {
			return this.dist - o.dist;
		}
	}
}
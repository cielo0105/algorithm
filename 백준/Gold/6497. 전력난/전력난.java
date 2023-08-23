import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 집 m개  길 n개
 * x, y, z (x번 집, y번 집 거리 z미터)
 * 
 * 
 */
public class Main {
	static int M, N;
	static Node[] house;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if(M == 0 && N == 0) break;
			house = new Node[N];
			parents = new int[M];
			int count = 0;
			int total = 0;
			int money = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				money += dist;
				house[i] = new Node(from, to, dist);
			}
			
			Arrays.sort(house);
			make();
			for(Node n:house) {
				if(union(n.from,n.to)) {
					total += n.dist;
					if(++count == M) {
						break;
					}
				}
			}
			sb.append(money-total).append("\n");
		}
		System.out.println(sb);
	}

	static void make() {
		for (int i = 0; i < M; i++) {
			parents[i] = i;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	static class Node implements Comparable<Node> {
		int from, to, dist;

		public Node(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.dist - o.dist;
		}
	}

}

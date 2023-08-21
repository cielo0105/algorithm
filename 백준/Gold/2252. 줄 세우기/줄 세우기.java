import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		cnt = new int[N+1];
		for(int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			cnt[to]++;
			arr.get(from).add(to);
		}
		
		for(int i=1; i<=N; i++) {
			if(cnt[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int next = q.poll();
			sb.append(next).append(" ");
			for(int i: arr.get(next)) {
				cnt[i]--;
				if(cnt[i]==0) q.add(i);
			}
		}
		System.out.println(sb);
	}
	
	
}
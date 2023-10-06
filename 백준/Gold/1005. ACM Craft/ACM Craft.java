import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K,target;
	static int[] time, connected, total;
	static ArrayList<ArrayList<Integer>> link;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			link = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물 개수
			K = Integer.parseInt(st.nextToken()); // 규칙 개수
			for(int i=0; i<=N; i++) {
				link.add(new ArrayList<>());
			}
			time = new int[N+1];
			connected = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) { // 걸리는 시간 저장
				time[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				link.get(from).add(to);
				connected[to]++;
			}
			target = Integer.parseInt(br.readLine());
			find();
			System.out.println(total[target]);
		}
	}
	
	static void find() {
		Queue<Integer> q = new ArrayDeque<>();
		total = new int[N+1]; // 총 걸리는 시간 저장하는 배열
		for(int i=1; i<=N; i++) {
			total[i] = time[i];
			if(connected[i]==0) q.add(i);
		}
		
		while(!q.isEmpty()) {
			int next = q.poll();
			if(next == target) return; // target 건물 찾으면 return
			for(int n:link.get(next)) {
				connected[n]--;
				if(connected[n] == 0) q.add(n); // 0이 된 경우 큐에 추가
				total[n] = Math.max(total[n], total[next]+time[n]); // 더 오래 걸리는 시간으로 갱신
			}
		}
	}
	
	static class Info{
		int x, time;
		public Info(int x, int time) {
			this.x = x;
			this.time =time;
		}
		
	}
}
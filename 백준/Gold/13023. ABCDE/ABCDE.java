
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	private static int flag = 0;
	private static int a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				DFS(i,1);
				if (flag == 1) break;
			}
		}
		if(flag == 1) System.out.println(1);
		else System.out.println(0);
	}
	
	public static void DFS(int n, int cnt) {
		if(cnt==5 || flag == 1) {
			flag = 1;
			return;
		}
		visited[n] = true;
		for (int next: graph[n]) {
			if(!visited[next]) {
				DFS(next,cnt+1);
			}
		}
		visited[n] = false;
	}
}

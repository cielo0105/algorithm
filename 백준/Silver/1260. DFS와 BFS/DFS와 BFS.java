

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		visited = new boolean[n+1];
		arr = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
			arr[b].add(a);
		}
		for (int i = 1; i <= n; i++) {
			Collections.sort(arr[i]);;
		}
		dfs(start);
		System.out.println();
		visited = new boolean[n+1];
		bfs(start);
	}
	
	static void dfs(int node) {
		System.out.print(node+ " ");
		visited[node] = true;
		for (int i  : arr[node]) {
			if(!visited[i]) dfs(i);
		}
	}
	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		visited[node] = true;
		while(!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next+" ");
			for (int i : arr[next]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}

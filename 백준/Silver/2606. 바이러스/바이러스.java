

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
	static int cnt = 0;
	static boolean[] check;
	static int graph[][];
	static int n;
	static int pair;
	static void dfs(int s) {
		if(check[s] == true) return;
		check[s] = true;
		cnt ++;
		for(int i=2;i<=n;i++) {
			if(graph[s][i]==1 && !check[i]){
				dfs(i);
			}
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pair = Integer.parseInt(br.readLine());
		graph = new int[n+1][n+1];
		check = new boolean[n+1];
		for(int i=0;i<pair;i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		dfs(1);
		System.out.println(cnt-1);
	}	
}


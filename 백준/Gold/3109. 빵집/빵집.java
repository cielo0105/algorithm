

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {	
	static int[][] graph;
	static int[] dx = {-1,0,1};
	static int[] dy = {1,1,1};
	static int r,c;
	static int flag = 0;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		graph = new int[r][c];
		for (int i = 0; i < r; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < c; j++) {
				if(str[j].equals(".")) graph[i][j] = 0;
				else graph[i][j] = 1;
			}
		}
		for (int i = 0; i < r; i++) {
			flag = 0;
			dfs(i,0);
		}
//		for (int[] g : graph) {
//			System.out.println(Arrays.toString(g));
//		}
		System.out.println(cnt);
	}
	
	static void dfs(int x,int y) {
		graph[x][y] = 2;
		if(y == c-1) {
			flag = 1;
			cnt ++;
			return;
		}
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx>=0 && nx<r && ny<c && graph[nx][ny] == 0) {
				if(flag == 1) return;
				dfs(nx,ny);
			}
		}
	}
}

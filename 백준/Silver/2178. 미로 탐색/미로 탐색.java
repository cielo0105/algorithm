
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] maze;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] l = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(l[j]);
			}
		}
		bfs(0,0);
		System.out.println(maze[n-1][m-1]);
	}
	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i,j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if(x>=0 && x<n && y>=0 && y<m) {
					if(!visited[x][y] && maze[x][y] == 1) {
						visited[x][y] = true;
						maze[x][y] = maze[now[0]][now[1]] + 1;
						queue.offer(new int[] {x,y});
					}
				}
			}
		}
	}
	
}

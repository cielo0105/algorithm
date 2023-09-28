import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * . 빈칸
 * # 벽
 * 소문자 : 열쇠
 * 대문자 : 문
 * 0 현재 위치
 * 1 출구
 */
public class Main {
	static int N,M;
	static char[][] map;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static boolean[][][] visited;
	static int answer = -1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1<<6];
		Info start = null;
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') start = new Info(i,j,0,0); // 시작 위치 저장
			}
		}
		
		find(start);
		System.out.println(answer);
	}
	
	static void find(Info start) {
		Queue<Info> q = new ArrayDeque<>();
		q.add(start);
		visited[start.x][start.y][0] = true;
		while(!q.isEmpty()) {
			Info info = q.poll();
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx<0 || nx>=N || ny<0 || ny>=M || visited[nx][ny][info.key] || map[nx][ny]=='#') continue;
				if(map[nx][ny] == '1') {
					answer = info.time + 1;
					return;
				}
				if(map[nx][ny]>='a' && map[nx][ny]<='f') { // 열쇠 칸
					int k = (1<<(map[nx][ny]-'a')) | info.key;
					visited[nx][ny][k] = true;
					q.add(new Info(nx,ny,k,info.time+1));
				}
				else if(map[nx][ny]>='A' && map[nx][ny]<='F') { // 문
					if((1<<(map[nx][ny]-'A') & info.key) != 0) { // key 존재
						visited[nx][ny][info.key] = true;
						q.add(new Info(nx,ny,info.key,info.time+1));
					}
				}
				else {
					visited[nx][ny][info.key] = true;
					q.add(new Info(nx,ny,info.key,info.time+1));
				}
			}
		}
	}
	
	static class Info{
		int x, y, key, time;
		public Info(int x, int y, int key, int time) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.time = time;
		}
	}
}
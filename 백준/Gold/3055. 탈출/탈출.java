import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * R*C
 * . 빈곳
 * * 물 - 매 분마다 빈칸으로 확장(비버굴은 안됨)
 * X 돌
 * D 비버굴
 * S 고슴도치 위치
 * 굴로 이동할 수 있는 가장 빠른 시간
 */
public class Main {
	static int R,C;
	static char[][] map;
	static Queue<Info> water = new ArrayDeque<>();
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int answer = Integer.MAX_VALUE;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		Info start = null;
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				if(map[i][j]=='S') {
					start = new Info(i,j,0);
					visited[i][j] = true;
					map[i][j] = '.';
				}
				else if(map[i][j]=='*') water.add(new Info(i,j,0));
			}
		}
		
		find(start);
		if(answer!=Integer.MAX_VALUE) System.out.println(answer);
		else System.out.println("KAKTUS");
	}
	
	static void find(Info start) {
		Queue<Info> q = new ArrayDeque<>();
		int time = 0;
		q.add(start);
		while(!q.isEmpty()) { 
			Info info = q.poll();
			if(info.time == time) water(time++);
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<R && ny>=0 && ny<C && !visited[nx][ny]) {
					if(map[nx][ny] == 'D') {
						answer = time;
						return;
					}
					if(map[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.add(new Info(nx,ny,time));
					}
				}
			}
		}
	}
	
	static void water(int time) {
		while(!water.isEmpty()) {
			if(water.peek().time > time) break;
			Info info = water.poll();
			for(int i=0; i<4; i++) {
				int nx = info.x + deltas[i][0];
				int ny = info.y + deltas[i][1];
				if(nx>=0 && nx<R && ny>=0 && ny<C && map[nx][ny]=='.') {
					map[nx][ny] = '*';
					water.add(new Info(nx,ny,time+1));
				}
			}
		}
	}
	
	
	static class Info{
		int x, y, time;
		public Info(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
			public String toString() {
				return this.x+" "+this.y+" "+this.time;
			}
	}
}
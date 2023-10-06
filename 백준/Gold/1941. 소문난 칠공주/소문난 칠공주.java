/*
 * 5*5 자리 배치
 * 소문난 칠공주 결성
 * 7명 중 4명 이상은 이다솜파(S)
 * 모든 학생 가로,세로로 인접해야 함
 * 결성할 수 있는 경우의 수
 * 
 * 
 */

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static boolean[][] visited = new boolean[5][5];
	static char[][] map = new char[5][5];
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<5; i++) {
			map[i] = br.readLine().toCharArray();
		}
		choose(0,0,0);
		System.out.println(ans);
	}
	
	static void choose(int start, int nth, int ds) {
		if(nth == 7) {
			if(ds >= 4) {
				if(check()) ans++; // 다솜파 4명 이상
			}
			return;
		}
		
		for(int i=start; i<25; i++) {
			int cnt = 0;
			visited[i/5][i%5] = true;
			if(map[i/5][i%5]=='S') cnt = 1;
			choose(i+1,nth+1,ds+cnt);
			visited[i/5][i%5] = false;
		}
	}
	
	static boolean check() {
		Point start = null;
		loop:
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(visited[i][j]) {
					start = new Point(i,j);
					break loop;
				}
			}
		}
		boolean[][] copyv = new boolean[5][5];
		for(int i=0; i<5; i++) {
			copyv[i] = visited[i].clone();
		}
		Queue<Point> q = new ArrayDeque<>();
		q.add(start);
		copyv[start.x][start.y] = false;
		int found = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				if(nx>=0 && nx<5 && ny>=0 && ny<5 && copyv[nx][ny]) {
					copyv[nx][ny] = false;
					q.add(new Point(nx,ny));
					found++;
				}
			}
		}
		if(found == 7) { // 다 찾음
			return true;
		}
		return false;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * R*C 
 * 1행1열에 말 놓여있음
 * 같은 알파벳 지나면 안됨
 * 최대 몇 칸 지날 수 있는지 구하는 문제
 * 
 */
public class Main {
	static char[][] graph;
	static int R,C;
	static int max = Integer.MIN_VALUE;
	static boolean[] visited = new boolean[26];
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	// A 65
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new char[R][C];
		for(int i=0; i<R; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		visited[(int)graph[0][0]-65] = true;
		find(0,0,0);
		System.out.println(max+1);
	}
	
	static void find(int x, int y, int depth) {
		max = Math.max(max, depth);
		for(int i=0; i<4; i++) {
			int nx = x + deltas[i][0];
			int ny = y + deltas[i][1];
			if(nx>=0 && nx<R && ny>=0 && ny<C) {
				if(!visited[(int)graph[nx][ny]-65]) {
					visited[(int)graph[nx][ny]-65] = true;
					find(nx,ny,depth+1);
					visited[(int)graph[nx][ny]-65] = false;
				}
				
			}
		}
		
	}
	
	static class Location{
		int x, y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
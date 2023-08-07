import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.print.attribute.HashPrintJobAttributeSet;

/**

@author 임현지
@since 2023. 8. 4.

@note 

*/

public class Main {
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[][] graph;
	static int M;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st = new  StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			graph = new int[M][N];
			for(int j=0; j<K; j++) {  // 그래프 값 입력 (배추 위치)
				st = new StringTokenizer(br.readLine());
				
				graph[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			int answer = 0;
			for(int a=0; a<M; a++) {
				for(int b=0; b<N; b++) {
					if(graph[a][b] == 1) {
						answer ++;
						bfs(a,b);
					}
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	
	}
	
	public static void bfs(int x, int y) {
		Queue<Location> queue = new LinkedList<>();
		graph[x][y] = 0;
		queue.add(new Location(x,y));
		while(!queue.isEmpty()) {
			Location l = queue.poll();
			x = l.x;
			y = l.y;
			for(int i=0; i<4; i++) {
				int nx = x + deltas[i][0];
				int ny = y + deltas[i][1];
				 
				if(nx>=0 && nx<M && ny>=0 && ny<N && graph[nx][ny]==1) {
					queue.add(new Location(nx,ny));
					graph[nx][ny] = 0;
				}
			}
		}
	}
	
	public static class Location{
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
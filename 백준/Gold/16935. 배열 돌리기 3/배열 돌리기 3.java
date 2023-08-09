import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] graph;
	static int[][] deltas;
	static int[][] leftDeltas;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		deltas = new int[][] {{0,M/2},{N/2,0},{0,-M/2},{-N/2,0}}; 
		leftDeltas = new int[][]  {{N/2,0},{0,M/2},{-N/2,0},{0,-M/2}};
		for(int i=0; i<N; i++) { // graph에 값 저장
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()); // 어느 연산
		for(int i=0; i<R; i++) {
			int nth = Integer.parseInt(st.nextToken());
			changeGraph(nth);
			N = graph.length;
			M = graph[0].length;
			
		}
		for(int[] arr: graph) {
			for(int i:arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] moveRight(int a, int b, int nth,int[][] arr) {
		int[][] change = arr;
		
		for(int i=a; i<a+N/2; i++) {
			for(int j=b; j<b+M/2; j++) {
				change[i][j] = graph[i+deltas[nth][0]][j+deltas[nth][1]];
			}
		}
		return change;
	}
	
	static int[][] moveLeft(int a, int b, int nth,int[][] arr) {
		int[][] change = arr;
		for(int i=a; i<a+N/2; i++) {
			for(int j=b; j<b+M/2; j++) {
				change[i][j] = graph[i+leftDeltas[nth][0]][j+leftDeltas[nth][1]];
			/*	System.out.println(a+" "+b);
				System.out.println(change[i][j]);*/
			}
		}
		return change;
	}
	
	static void changeGraph(int nth) { // 상하 반전 
		int[][] change = new int[N][M];
		if(nth==1) {
			for(int i=0; i<N; i++) {
				change[N-i-1] = graph[i];
			}
			graph = change;
			
		}
		else if(nth==2) { // 0,0 -> 0,M-1  0,1 -> 0,M-2 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					change[i][j] = graph[i][M-j-1];
				}
			}
			graph = change;
		}
		
		else if(nth==3) { // 오른쪽 90도 회전\
			
			/*  N=6 M=8
			 *  (0,5) -> 5,5 j,
			 * (0,4) -> 4,4  
			 * 4,1 -> 1,1
			 * 4,2 -> 2,1
			 * */
	
			change = new int[M][N]; //[8][6]
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					change[j][N-i-1] = graph[i][j];
				}
			}
			graph = new int[N][M];
			graph = change;
			
		}
		else if(nth==4) { // 왼쪽 90도 회전
			change = new int[M][N];
			// 0,0 -> 0,M 
			// 0,1 -> 1,M
			// 1,0 -> 0,M-1
			// 5,0 -> 
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					change[i][j] = graph[j][M-i-1];
				}
			}
			graph = new int[N][M];
			graph = change;
		}
		else if(nth==5) { // 부분배열 시계방향
			leftDeltas = new int[][]  {{N/2,0},{0,M/2},{-N/2,0},{0,-M/2}}; 
			change = new int[N][M];
			int a = 0;
			int b = 0;
			for(int i=0; i<4; i++) {
				if(i==0) change = moveLeft(a,b,0,change);
				 
				else {
					a += leftDeltas[i-1][0];
					b += leftDeltas[i-1][1];
					change = moveLeft(a,b,i,change); // 사분면 시작 위치
				}
			}
			graph = change;
		}
		else if(nth==6) { // 부분배열 반시계방향
			deltas = new int[][] {{0,M/2},{N/2,0},{0,-M/2},{-N/2,0}}; 
			change = new int[N][M];
			int a = 0;
			int b = 0;
			for(int i=0; i<4; i++) {
				if(i==0) change = moveRight(a,b,0,change);
				 
				else {
					a += deltas[i-1][0];
					b += deltas[i-1][1];
					change = moveRight(a,b,i,change); // 사분면 시작 위치
				
				}
			}
			graph = change;
		}
	}
	
}